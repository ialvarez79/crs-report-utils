//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2018.06.03 at 12:10:04 AM UYT 
//


package com.tercevall.crsreport.input.entities;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 * This container brings together all data about an organisation as a party. Name and address are required components and each can
 * be present more than once to enable as complete a description as possible. Whenever possible one or more identifiers (TIN
 * etc) should be added as well as a residence country code. Additional data that describes and identifies the party can be
 * given . The code for the legal type according to the OECD codelist must be added. The structures of
 * all of the subelements are defined elsewhere in this schema.
 * 
 * <p>Java class for OrganisationParty_Type complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="OrganisationParty_Type">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ResCountryCode" type="{urn:oecd:ties:isocrstypes:v1}CountryCode_Type" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="IN" type="{urn:oecd:ties:crs:v1}OrganisationIN_Type" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Name" type="{urn:oecd:ties:commontypesfatcacrs:v1}NameOrganisation_Type" maxOccurs="unbounded"/>
 *         &lt;element name="Address" type="{urn:oecd:ties:commontypesfatcacrs:v1}Address_Type" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OrganisationParty_Type", namespace = "urn:oecd:ties:crs:v1", propOrder = {
    "resCountryCode",
    "in",
    "name",
    "address"
})
@XmlSeeAlso({
    CorrectableOrganisationPartyType.class
})
public class OrganisationPartyType {

    @XmlElement(name = "ResCountryCode")
    @XmlSchemaType(name = "string")
    protected List<CountryCodeType> resCountryCode;
    @XmlElement(name = "IN")
    protected List<OrganisationINType> in;
    @XmlElement(name = "Name", required = true)
    protected List<NameOrganisationType> name;
    @XmlElement(name = "Address", required = true)
    protected List<AddressType> address;

    /**
     * Gets the value of the resCountryCode property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the resCountryCode property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getResCountryCode().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CountryCodeType }
     * 
     * 
     */
    public List<CountryCodeType> getResCountryCode() {
        if (resCountryCode == null) {
            resCountryCode = new ArrayList<CountryCodeType>();
        }
        return this.resCountryCode;
    }

    /**
     * Gets the value of the in property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the in property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getIN().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link OrganisationINType }
     * 
     * 
     */
    public List<OrganisationINType> getIN() {
        if (in == null) {
            in = new ArrayList<OrganisationINType>();
        }
        return this.in;
    }

    /**
     * Gets the value of the name property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the name property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getName().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link NameOrganisationType }
     * 
     * 
     */
    public List<NameOrganisationType> getName() {
        if (name == null) {
            name = new ArrayList<NameOrganisationType>();
        }
        return this.name;
    }

    /**
     * Gets the value of the address property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the address property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAddress().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AddressType }
     * 
     * 
     */
    public List<AddressType> getAddress() {
        if (address == null) {
            address = new ArrayList<AddressType>();
        }
        return this.address;
    }

}
