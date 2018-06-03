//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2018.06.03 at 12:10:04 AM UYT 
//


package com.tercevall.crsreport.input.entities;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CrsPaymentType_EnumType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="CrsPaymentType_EnumType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="CRS501"/>
 *     &lt;enumeration value="CRS502"/>
 *     &lt;enumeration value="CRS503"/>
 *     &lt;enumeration value="CRS504"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "CrsPaymentType_EnumType", namespace = "urn:oecd:ties:crs:v1")
@XmlEnum
public enum CrsPaymentTypeEnumType {


    /**
     * Dividends
     * 
     */
    @XmlEnumValue("CRS501")
    CRS_501("CRS501"),

    /**
     * Interest
     * 
     */
    @XmlEnumValue("CRS502")
    CRS_502("CRS502"),

    /**
     * Gross Proceeds/Redemptions
     * 
     */
    @XmlEnumValue("CRS503")
    CRS_503("CRS503"),

    /**
     * Other - CRS
     * 
     */
    @XmlEnumValue("CRS504")
    CRS_504("CRS504");
    private final String value;

    CrsPaymentTypeEnumType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static CrsPaymentTypeEnumType fromValue(String v) {
        for (CrsPaymentTypeEnumType c: CrsPaymentTypeEnumType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
