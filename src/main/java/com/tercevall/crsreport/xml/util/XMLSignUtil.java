package com.tercevall.crsreport.xml.util;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.cert.X509Certificate;

import org.apache.xml.security.signature.XMLSignature;
import org.apache.xml.security.transforms.Transforms;
import org.apache.xml.security.keys.KeyInfo;
import org.apache.xml.security.utils.Constants;
import org.apache.xml.security.utils.XMLUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import java.security.Key;
import java.security.KeyStore;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;

import javax.xml.namespace.QName;
import javax.xml.parsers.DocumentBuilder;


public class XMLSignUtil {
    private static XMLSignUtil ourInstance = new XMLSignUtil();

    public static XMLSignUtil getInstance() {
        return ourInstance;
    }

    static
    {
        org.apache.xml.security.Init.init();
    }

    public static void signDocument(String fileName, String signedFileName,
                                       String ksType,
                                       String ksFile,
                                       String ksPass,
                                       String pkAlias,
                                       String pkPass,
                                       String certAlias) throws Exception
    {
        // Read in plaintext document
        InputStream sourceDocument =
                this.getClass().getClassLoader().getResourceAsStream(fileName);
        DocumentBuilder builder = XMLUtils.createDocumentBuilder(false);
        Document document = builder.parse(sourceDocument);

        // Set up the Key
        KeyStore keyStore = KeyStore.getInstance(ksType);
        keyStore.load(
                this.getClass().getClassLoader().getResource(ksFile).openStream(),
                ksPass.toCharArray()
        );
        Key key = keyStore.getKey(pkAlias, pkPass.toCharArray());
        X509Certificate cert = (X509Certificate)keyStore.getCertificate(certAlias);

        // Sign using DOM
        XMLSignature sig =
                new XMLSignature(document, "", "http://www.w3.org/2000/09/xmldsig#rsa-sha1", "http://www.w3.org/2001/10/xml-exc-c14n#");
        Element root = document.getDocumentElement();
        root.appendChild(sig.getElement());

        Transforms transforms = new Transforms(document);
        transforms.addTransform(Transforms.TRANSFORM_ENVELOPED_SIGNATURE);
        transforms.addTransform("http://www.w3.org/2001/10/xml-exc-c14n#");

        sig.addDocument("", transforms, "http://www.w3.org/2000/09/xmldsig#sha1");

        sig.sign(key);

        if (cert != null) {
            sig.addKeyInfo(cert);
        }

        FileOutputStream fos;
        try{
            fos = new FileOutputStream(signedFileName);
            XMLUtils.outputDOM(document, fos);
        } finally {
            fos.close()
        }
    }
}
