package com.tercevall.crsreport.xml.util;

import java.io.FileInputStream;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.cert.X509Certificate;

import org.apache.xml.security.signature.XMLSignature;
import org.apache.xml.security.transforms.Transforms;
import org.apache.xml.security.keys.KeyInfo;
import org.apache.xml.security.utils.Constants;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;



public class XMLSignUtil {
    private static XMLSignUtil ourInstance = new XMLSignUtil();

    public static XMLSignUtil getInstance() {
        return ourInstance;
    }

    static
    {
        org.apache.xml.security.Init.init();
    }

    /**
     * Method to create an enveloped signature within the 'data' to be signed.
     * @param data The XML node that needs to be signed to create the Signature element
     * @param ksType keystore type
     * @param ksFile location of the keystore file
     * @param ksPass keystore password
     * @param pkAlias private key alias
     * @param pkPass private key password
     * @param certAlias certificate alias
     * @return The XML Digital Signature, contained with the 'data' element
     */
    public static Node createSignature(Node data,
                                       String ksType,
                                       String ksFile,
                                       String ksPass,
                                       String pkAlias,
                                       String pkPass,
                                       String certAlias) throws Exception
    {
        KeyStore ks = KeyStore.getInstance(ksType);
        FileInputStream fis = new FileInputStream(ksFile);

        //Load keystore
        ks.load(fis, ksPass.toCharArray());

        //Locate private key for signing.
        PrivateKey privateKey = (PrivateKey)ks.getKey(pkAlias, pkPass.toCharArray());

        Document doc = new XDocument(data).getDocument();

        //Creating a signature from an in-memory DOM, so no concept of files.
        String BaseURI = "";

        // Create the basic structure of the signature.
        // The doc argument here denotes the document where the Signature Element will be appended
        XMLSignature sig = new XMLSignature(doc, BaseURI, XMLSignature.ALGO_ID_SIGNATURE_DSA);

        // Append the signature to the doc because this will be an Enveloped Signature
        doc.getDocumentElement().appendChild(sig.getElement());

        // Might need a NullURI-type resolver because the URI="" is used to indicate no external references.
        // In the case where URI="" the container document for the Signature element is assumed to be the data
        /* sig.addResourceResolver(
            new NullURIReferenceResolver(new XDocument(doc).toString().getBytes())
        );*/

        {
            //Transforms object for the type of Signature data and references
            Transforms transforms = new Transforms(doc);
            //Inform the engine that it's an enveloped signature. This will ensure that the signature element is stripped out.
            transforms.addTransform(Transforms.TRANSFORM_ENVELOPED_SIGNATURE);
            //Canonicalised part of the signature element.
            transforms.addTransform(Transforms.TRANSFORM_C14N_WITH_COMMENTS);
            //Add the document for which the signature is required.
            sig.addDocument("", transforms, Constants.ALGO_ID_DIGEST_SHA1);
        }

        {
            //Add in the KeyInfo for the certificate to enable later verification
            X509Certificate cert = (X509Certificate)ks.getCertificate(certAlias);
            sig.addKeyInfo(cert);
            sig.addKeyInfo(cert.getPublicKey());
            //Now create the signature
            sig.sign(privateKey);
        }

        /* See the data that was actually used to create the signature element
        SignedInfo s = sig.getSignedInfo();
        for (int i = 0; i < s.getSignedContentLength(); i++) {
            System.out.println("***** Signed Content " + i + " *****");
            System.out.println(new String(s.getSignedContentItem(i)));
            System.out.println(s.getReferencedContentAfterTransformsItem(i).getBytes());
            if (log.isDebugEnabled()) {
                            log.debug(s.getReferencedContentAfterTransformsItem(i).getBytes());
                        }
        }
        */

        //Return the signed data to the factbase
        return doc;
    }

    /**
     * Verifies an XML node with an enveloped Signature element
     * @param data The XML node containing the data that was used to create the signature. The data also contains the Signature element.
     * @return A status Node indicating the state of the certificate info and the outcome of the verification process.
     */
    public static Node verifySignature(Node data) throws Exception
    {
        String keyInfoStatus = "";
        String sigStatus = " The XML signature is invalid";
        String sigValid = "invalid";
        try {
            XDocument sigPart = new XDocument(data);
            sigPart.addNamespace("ds", Constants.SignatureSpecNS);
            Node sigElement = sigPart.selectSingleNode("//ds:Signature[1]");

            if (sigElement != null)
            {
                String BaseURI = "";
                XMLSignature signature = new XMLSignature((Element)sigElement, BaseURI);
                //signature.addResourceResolver(new NullURIReferenceResolver(new XDocument(data).toString().getBytes()));

                KeyInfo ki = signature.getKeyInfo();
                if (ki != null)
                {
                    if (ki.containsX509Data())
                    {
                        keyInfoStatus += " Found X509Data within the KeyInfo element.";
                    }

                    X509Certificate cert = signature.getKeyInfo().getX509Certificate();
                    if (cert != null)
                    {
                        if (signature.checkSignatureValue(cert))
                        {
                            sigStatus = " The XML signature is valid";
                            sigValid = "valid";
                        }
                    }
                    else
                    {
                        keyInfoStatus += " Could not locate a Certificate.";

                        PublicKey pk = signature.getKeyInfo().getPublicKey();
                        if (pk != null)
                        {
                            keyInfoStatus += " Located public key.";
                            if (signature.checkSignatureValue(pk))
                            {
                                sigStatus = " The XML signature is valid";
                                sigValid = "valid";
                            }
                        }
                        else
                        {
                            keyInfoStatus += " Could not locate a public key - unable to check the signature.";
                        }
                    }
                }
                else
                {
                    keyInfoStatus += " Could not locate KeyInfo element - unable to check the signature.";
                }
            }
            else
            {
                keyInfoStatus += " Could not locate Signature element - unable to check the signature.";
            }
        }
        catch (Exception ex)
        {
            throw ex;
        }

        XDocument response = new XDocument("<signature_verification status='" + sigValid + "'>"
                + keyInfoStatus + "**" + sigStatus + "**"
                + "</signature_verification>");
        return response.getRootNode();
    }
}
