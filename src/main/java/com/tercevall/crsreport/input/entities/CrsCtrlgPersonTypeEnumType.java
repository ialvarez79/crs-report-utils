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
 * <p>Java class for CrsCtrlgPersonType_EnumType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="CrsCtrlgPersonType_EnumType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="CRS801"/>
 *     &lt;enumeration value="CRS802"/>
 *     &lt;enumeration value="CRS803"/>
 *     &lt;enumeration value="CRS804"/>
 *     &lt;enumeration value="CRS805"/>
 *     &lt;enumeration value="CRS806"/>
 *     &lt;enumeration value="CRS807"/>
 *     &lt;enumeration value="CRS808"/>
 *     &lt;enumeration value="CRS809"/>
 *     &lt;enumeration value="CRS810"/>
 *     &lt;enumeration value="CRS811"/>
 *     &lt;enumeration value="CRS812"/>
 *     &lt;enumeration value="CRS813"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "CrsCtrlgPersonType_EnumType", namespace = "urn:oecd:ties:crs:v1")
@XmlEnum
public enum CrsCtrlgPersonTypeEnumType {


    /**
     * CP of legal person - ownership
     * 
     */
    @XmlEnumValue("CRS801")
    CRS_801("CRS801"),

    /**
     * CP of legal person - other means
     * 
     */
    @XmlEnumValue("CRS802")
    CRS_802("CRS802"),

    /**
     * CP of legal person - senior managing official
     * 
     */
    @XmlEnumValue("CRS803")
    CRS_803("CRS803"),

    /**
     * CP of legal arrangement - trust - settlor
     * 
     */
    @XmlEnumValue("CRS804")
    CRS_804("CRS804"),

    /**
     * CP of legal arrangement - trust - trustee
     * 
     */
    @XmlEnumValue("CRS805")
    CRS_805("CRS805"),

    /**
     * CP of legal arrangement - trust - protector
     * 
     */
    @XmlEnumValue("CRS806")
    CRS_806("CRS806"),

    /**
     * CP of legal arrangement - trust - beneficiary
     * 
     */
    @XmlEnumValue("CRS807")
    CRS_807("CRS807"),

    /**
     * CP of legal arrangement - trust - other
     * 
     */
    @XmlEnumValue("CRS808")
    CRS_808("CRS808"),

    /**
     * CP of legal arrangement - other - settlor-equivalent
     * 
     */
    @XmlEnumValue("CRS809")
    CRS_809("CRS809"),

    /**
     * CP of legal arrangement - other - trustee-equivalent
     * 
     */
    @XmlEnumValue("CRS810")
    CRS_810("CRS810"),

    /**
     * CP of legal arrangement - other - protector-equivalent
     * 
     */
    @XmlEnumValue("CRS811")
    CRS_811("CRS811"),

    /**
     * CP of legal arrangement - other - beneficiary-equivalent
     * 
     */
    @XmlEnumValue("CRS812")
    CRS_812("CRS812"),

    /**
     * CP of legal arrangement - other - other-equivalent
     * 
     */
    @XmlEnumValue("CRS813")
    CRS_813("CRS813");
    private final String value;

    CrsCtrlgPersonTypeEnumType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static CrsCtrlgPersonTypeEnumType fromValue(String v) {
        for (CrsCtrlgPersonTypeEnumType c: CrsCtrlgPersonTypeEnumType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
