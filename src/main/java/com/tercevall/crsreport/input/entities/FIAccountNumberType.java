//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2018.06.02 at 08:48:36 PM UYT 
//


package com.tercevall.crsreport.input.entities;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;


/**
 * Account number definition  
 * 
 * <p>Java class for FIAccountNumber_Type complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="FIAccountNumber_Type">
 *   &lt;simpleContent>
 *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
 *       &lt;attribute name="AcctNumberType" use="required" type="{urn:oecd:ties:commontypesfatcacrs:v1}AcctNumberType_EnumType" />
 *       &lt;attribute name="UndocumentedAccount" use="required" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="ClosedAccount" use="required" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="DormantAccount" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="PreexistingAccount" use="required" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="TopBalanceAccount" use="required" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *     &lt;/extension>
 *   &lt;/simpleContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FIAccountNumber_Type", namespace = "urn:oecd:ties:crs:v1", propOrder = {
    "value"
})
public class FIAccountNumberType {

    @XmlValue
    protected String value;
    @XmlAttribute(name = "AcctNumberType", required = true)
    protected AcctNumberTypeEnumType acctNumberType;
    @XmlAttribute(name = "UndocumentedAccount", required = true)
    protected boolean undocumentedAccount;
    @XmlAttribute(name = "ClosedAccount", required = true)
    protected boolean closedAccount;
    @XmlAttribute(name = "DormantAccount")
    protected Boolean dormantAccount;
    @XmlAttribute(name = "PreexistingAccount", required = true)
    protected boolean preexistingAccount;
    @XmlAttribute(name = "TopBalanceAccount", required = true)
    protected boolean topBalanceAccount;

    /**
     * Gets the value of the value property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getValue() {
        return value;
    }

    /**
     * Sets the value of the value property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * Gets the value of the acctNumberType property.
     * 
     * @return
     *     possible object is
     *     {@link AcctNumberTypeEnumType }
     *     
     */
    public AcctNumberTypeEnumType getAcctNumberType() {
        return acctNumberType;
    }

    /**
     * Sets the value of the acctNumberType property.
     * 
     * @param value
     *     allowed object is
     *     {@link AcctNumberTypeEnumType }
     *     
     */
    public void setAcctNumberType(AcctNumberTypeEnumType value) {
        this.acctNumberType = value;
    }

    /**
     * Gets the value of the undocumentedAccount property.
     * 
     */
    public boolean isUndocumentedAccount() {
        return undocumentedAccount;
    }

    /**
     * Sets the value of the undocumentedAccount property.
     * 
     */
    public void setUndocumentedAccount(boolean value) {
        this.undocumentedAccount = value;
    }

    /**
     * Gets the value of the closedAccount property.
     * 
     */
    public boolean isClosedAccount() {
        return closedAccount;
    }

    /**
     * Sets the value of the closedAccount property.
     * 
     */
    public void setClosedAccount(boolean value) {
        this.closedAccount = value;
    }

    /**
     * Gets the value of the dormantAccount property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isDormantAccount() {
        return dormantAccount;
    }

    /**
     * Sets the value of the dormantAccount property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setDormantAccount(Boolean value) {
        this.dormantAccount = value;
    }

    /**
     * Gets the value of the preexistingAccount property.
     * 
     */
    public boolean isPreexistingAccount() {
        return preexistingAccount;
    }

    /**
     * Sets the value of the preexistingAccount property.
     * 
     */
    public void setPreexistingAccount(boolean value) {
        this.preexistingAccount = value;
    }

    /**
     * Gets the value of the topBalanceAccount property.
     * 
     */
    public boolean isTopBalanceAccount() {
        return topBalanceAccount;
    }

    /**
     * Sets the value of the topBalanceAccount property.
     * 
     */
    public void setTopBalanceAccount(boolean value) {
        this.topBalanceAccount = value;
    }

}