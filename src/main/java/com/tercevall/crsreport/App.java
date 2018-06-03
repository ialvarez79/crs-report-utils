package com.tercevall.crsreport;

import javax.xml.bind.JAXBException;

import com.tercevall.crsreport.input.entities.CRSOECD;

import java.io.IOException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws JAXBException,IOException
    {
    	CRSOECD report = XMLDebugger.buildFakeElement();
    	XMLDebugger.debugXML(report);
    }
}
