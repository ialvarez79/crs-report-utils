//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2018.06.03 at 12:10:04 AM UYT 
//


package com.tercevall.crsreport.input.entities;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CorrectablePoolReport_Type complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CorrectablePoolReport_Type">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="DocSpec" type="{urn:oecd:ties:stf:v4}DocSpec_Type"/>
 *         &lt;element name="AccountCount" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *         &lt;element name="AccountPoolReportType" type="{urn:oecd:ties:fatca:v1}FatcaAcctPoolReportType_EnumType"/>
 *         &lt;element name="PoolBalance" type="{urn:oecd:ties:commontypesfatcacrs:v1}MonAmnt_Type"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CorrectablePoolReport_Type", namespace = "urn:oecd:ties:fatca:v1", propOrder = {
    "docSpec",
    "accountCount",
    "accountPoolReportType",
    "poolBalance"
})
public class CorrectablePoolReportType {

    @XmlElement(name = "DocSpec", required = true)
    protected DocSpecType docSpec;
    @XmlElement(name = "AccountCount", required = true)
    protected BigInteger accountCount;
    @XmlElement(name = "AccountPoolReportType", required = true)
    @XmlSchemaType(name = "string")
    protected FatcaAcctPoolReportTypeEnumType accountPoolReportType;
    @XmlElement(name = "PoolBalance", required = true)
    protected MonAmntType poolBalance;

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
     * Gets the value of the accountCount property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getAccountCount() {
        return accountCount;
    }

    /**
     * Sets the value of the accountCount property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setAccountCount(BigInteger value) {
        this.accountCount = value;
    }

    /**
     * Gets the value of the accountPoolReportType property.
     * 
     * @return
     *     possible object is
     *     {@link FatcaAcctPoolReportTypeEnumType }
     *     
     */
    public FatcaAcctPoolReportTypeEnumType getAccountPoolReportType() {
        return accountPoolReportType;
    }

    /**
     * Sets the value of the accountPoolReportType property.
     * 
     * @param value
     *     allowed object is
     *     {@link FatcaAcctPoolReportTypeEnumType }
     *     
     */
    public void setAccountPoolReportType(FatcaAcctPoolReportTypeEnumType value) {
        this.accountPoolReportType = value;
    }

    /**
     * Gets the value of the poolBalance property.
     * 
     * @return
     *     possible object is
     *     {@link MonAmntType }
     *     
     */
    public MonAmntType getPoolBalance() {
        return poolBalance;
    }

    /**
     * Sets the value of the poolBalance property.
     * 
     * @param value
     *     allowed object is
     *     {@link MonAmntType }
     *     
     */
    public void setPoolBalance(MonAmntType value) {
        this.poolBalance = value;
    }

}
