//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2018.06.02 at 08:48:36 PM UYT 
//


package com.tercevall.crsreport.input.entities;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CrsAcctHolderType_EnumType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="CrsAcctHolderType_EnumType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="CRS101"/>
 *     &lt;enumeration value="CRS102"/>
 *     &lt;enumeration value="CRS103"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "CrsAcctHolderType_EnumType", namespace = "urn:oecd:ties:crs:v1")
@XmlEnum
public enum CrsAcctHolderTypeEnumType {


    /**
     * Passive Non-Financial Entity with one or more controlling person that is a Reportable Person
     * 
     */
    @XmlEnumValue("CRS101")
    CRS_101("CRS101"),

    /**
     * CRS Reportable Person
     * 
     */
    @XmlEnumValue("CRS102")
    CRS_102("CRS102"),

    /**
     * Passive NFE that is a CRS Reportable Person
     * 
     */
    @XmlEnumValue("CRS103")
    CRS_103("CRS103");
    private final String value;

    CrsAcctHolderTypeEnumType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static CrsAcctHolderTypeEnumType fromValue(String v) {
        for (CrsAcctHolderTypeEnumType c: CrsAcctHolderTypeEnumType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}