//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2018.06.03 at 12:10:04 AM UYT 
//


package com.tercevall.crsreport.input.entities;

import java.math.BigDecimal;
import javax.xml.bind.annotation.adapters.XmlAdapter;

public class Adapter4
    extends XmlAdapter<String, BigDecimal>
{


    public BigDecimal unmarshal(String value) {
        return (javax.xml.bind.DatatypeConverter.parseDecimal(value));
    }

    public String marshal(BigDecimal value) {
        return (com.tercevall.crsreport.util.convert.BigDecimalConverter.printTwoDigitDecimal(value));
    }

}
