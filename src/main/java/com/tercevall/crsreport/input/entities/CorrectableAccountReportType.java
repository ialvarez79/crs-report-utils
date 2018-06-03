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
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CorrectableAccountReport_Type complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CorrectableAccountReport_Type">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="DocSpec" type="{urn:oecd:ties:stf:v4}DocSpec_Type"/>
 *         &lt;element name="AccountNumber" type="{urn:oecd:ties:crs:v1}FIAccountNumber_Type"/>
 *         &lt;element name="AccountHolder" type="{urn:oecd:ties:crs:v1}AccountHolder_Type"/>
 *         &lt;element name="ControllingPerson" type="{urn:oecd:ties:crs:v1}ControllingPerson_Type" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="AccountBalance" type="{urn:oecd:ties:commontypesfatcacrs:v1}MonAmnt_Type"/>
 *         &lt;element name="AccountAverage" type="{urn:oecd:ties:commontypesfatcacrs:v1}MonAmnt_Type"/>
 *         &lt;element name="Payment" type="{urn:oecd:ties:crs:v1}Payment_Type" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CorrectableAccountReport_Type", namespace = "urn:oecd:ties:crs:v1", propOrder = {
    "docSpec",
    "accountNumber",
    "accountHolder",
    "controllingPerson",
    "accountBalance",
    "accountAverage",
    "payment"
})
public class CorrectableAccountReportType {

    @XmlElement(name = "DocSpec", required = true)
    protected DocSpecType docSpec;
    @XmlElement(name = "AccountNumber", required = true)
    protected FIAccountNumberType accountNumber;
    @XmlElement(name = "AccountHolder", required = true)
    protected AccountHolderType accountHolder;
    @XmlElement(name = "ControllingPerson")
    protected List<ControllingPersonType> controllingPerson;
    @XmlElement(name = "AccountBalance", required = true)
    protected MonAmntType accountBalance;
    @XmlElement(name = "AccountAverage", required = true)
    protected MonAmntType accountAverage;
    @XmlElement(name = "Payment")
    protected List<PaymentType> payment;

    /**
     * Gets the value of the docSpec property.
     * 
     * @return
     *     possible object is
     *     {@link DocSpecType }
     *     
     */
    public DocSpecType getDocSpec() {
        return docSpec;
    }

    /**
     * Sets the value of the docSpec property.
     * 
     * @param value
     *     allowed object is
     *     {@link DocSpecType }
     *     
     */
    public void setDocSpec(DocSpecType value) {
        this.docSpec = value;
    }

    /**
     * Gets the value of the accountNumber property.
     * 
     * @return
     *     possible object is
     *     {@link FIAccountNumberType }
     *     
     */
    public FIAccountNumberType getAccountNumber() {
        return accountNumber;
    }

    /**
     * Sets the value of the accountNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link FIAccountNumberType }
     *     
     */
    public void setAccountNumber(FIAccountNumberType value) {
        this.accountNumber = value;
    }

    /**
     * Gets the value of the accountHolder property.
     * 
     * @return
     *     possible object is
     *     {@link AccountHolderType }
     *     
     */
    public AccountHolderType getAccountHolder() {
        return accountHolder;
    }

    /**
     * Sets the value of the accountHolder property.
     * 
     * @param value
     *     allowed object is
     *     {@link AccountHolderType }
     *     
     */
    public void setAccountHolder(AccountHolderType value) {
        this.accountHolder = value;
    }

    /**
     * Gets the value of the controllingPerson property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the controllingPerson property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getControllingPerson().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ControllingPersonType }
     * 
     * 
     */
    public List<ControllingPersonType> getControllingPerson() {
        if (controllingPerson == null) {
            controllingPerson = new ArrayList<ControllingPersonType>();
        }
        return this.controllingPerson;
    }

    /**
     * Gets the value of the accountBalance property.
     * 
     * @return
     *     possible object is
     *     {@link MonAmntType }
     *     
     */
    public MonAmntType getAccountBalance() {
        return accountBalance;
    }

    /**
     * Sets the value of the accountBalance property.
     * 
     * @param value
     *     allowed object is
     *     {@link MonAmntType }
     *     
     */
    public void setAccountBalance(MonAmntType value) {
        this.accountBalance = value;
    }

    /**
     * Gets the value of the accountAverage property.
     * 
     * @return
     *     possible object is
     *     {@link MonAmntType }
     *     
     */
    public MonAmntType getAccountAverage() {
        return accountAverage;
    }

    /**
     * Sets the value of the accountAverage property.
     * 
     * @param value
     *     allowed object is
     *     {@link MonAmntType }
     *     
     */
    public void setAccountAverage(MonAmntType value) {
        this.accountAverage = value;
    }

    /**
     * Gets the value of the payment property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the payment property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPayment().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PaymentType }
     * 
     * 
     */
    public List<PaymentType> getPayment() {
        if (payment == null) {
            payment = new ArrayList<PaymentType>();
        }
        return this.payment;
    }

}
