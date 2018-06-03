package com.tercevall.crsreport;

import java.util.Calendar;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import com.tercevall.crsreport.input.entities.CRSOECD;
import com.tercevall.crsreport.input.entities.CountryCodeType;
import com.tercevall.crsreport.input.entities.CrsMessageTypeIndicEnumType;
import com.tercevall.crsreport.input.entities.MessageSpecType;
import com.tercevall.crsreport.input.entities.MessageTypeEnumType;
import com.tercevall.crsreport.input.entities.ObjectFactory;

public class XMLDebugger {
	public static void debugXML(CRSOECD element) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance("com.tercevall.crsreport.input.entities");
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty("jaxb.formatted.output",Boolean.TRUE);
        marshaller.marshal(element,System.out);
	}
	
	public static CRSOECD buildFakeElement() {
		ObjectFactory objectFactory = new ObjectFactory();
		
		CRSOECD parent = objectFactory.createCRSOECD();
		
		MessageSpecType messageSpec = objectFactory.createMessageSpecType();
		parent.setMessageSpec(messageSpec);
		
		/*
		 * 		<SendingCompanyIN>210639630014</SendingCompanyIN>
		<TransmittingCountry>UY</TransmittingCountry>
		<ReceivingCountry>CA</ReceivingCountry>
		<MessageType>CRS</MessageType>
		<MessageRefId>UY2017CA.210639630014.000000055</MessageRefId>
		<MessageTypeIndic>CRS701</MessageTypeIndic>
		<ReportingPeriod>2017-12-31</ReportingPeriod>
		<Timestamp>2018-02-09T15:50:56</Timestamp>
		*/
		messageSpec.setSendingCompanyIN("210639630014");
		messageSpec.setTransmittingCountry(CountryCodeType.UY);
		messageSpec.setReceivingCountry(CountryCodeType.CA);
		messageSpec.setMessageType(MessageTypeEnumType.CRS);
		messageSpec.setMessageRefId("UY2017CA.210639630014.000000055");
		messageSpec.setMessageTypeIndic(CrsMessageTypeIndicEnumType.CRS_701); //FIXME - Nacho - REVISAR
		Calendar reportingPeriod = Calendar.getInstance();
		reportingPeriod.set(2017, 11, 31);
		messageSpec.setReportingPeriod(reportingPeriod);
		Calendar timeStamp = Calendar.getInstance();
		messageSpec.setTimestamp(timeStamp);
		
		/*
		 * 	<CrsBody>
		<ReportingFI>
			<ResCountryCode>UY</ResCountryCode>
			<IN issuedBy="UY" INType="RUC">210639630014</IN>
			<Name nameType="OECD207">BHU</Name>
			<Address legalAddressType="OECD301">
				<CountryCode xmlns="urn:oecd:ties:commontypesfatcacrs:v1">UY</CountryCode>
				<AddressFix xmlns="urn:oecd:ties:commontypesfatcacrs:v1">
					<City>Montevideo</City>
				</AddressFix>
			</Address>
			<DocSpec>
				<DocTypeIndic xmlns="urn:oecd:ties:stf:v4">OECD11</DocTypeIndic>
				<DocRefId xmlns="urn:oecd:ties:stf:v4">UY.210639630014.000000043</DocRefId>
			</DocSpec>
		</ReportingFI>
		<ReportingGroup>
			<AccountReport>
				<DocSpec>
					<DocTypeIndic xmlns="urn:oecd:ties:stf:v4">OECD11</DocTypeIndic>
					<DocRefId xmlns="urn:oecd:ties:stf:v4">UY.210639630014.000000044</DocRefId>
				</DocSpec>
				<AccountNumber AcctNumberType="OECD602"
					UndocumentedAccount="false" ClosedAccount="false"
					PreexistingAccount="false" TopBalanceAccount="false">10-84-114313-0</AccountNumber>
				<AccountHolder>
					<Individual>
						<ResCountryCode>CA</ResCountryCode>
						<TIN issuedBy="CA" INType="CI">45100134</TIN>
						<Name nameType="OECD202">
							<FirstName>TRILCE                        </FirstName>
							<LastName>GERVAZ              </LastName>
						</Name>
						<Address>
							<CountryCode xmlns="urn:oecd:ties:commontypesfatcacrs:v1">UY</CountryCode>
							<AddressFix xmlns="urn:oecd:ties:commontypesfatcacrs:v1">
								<City>OTTAWA         </City>
							</AddressFix>
						</Address>
						<BirthInfo>
							<BirthDate>1991-02-12</BirthDate>
							<City>OTTAWA         </City>
						</BirthInfo>
					</Individual>
				</AccountHolder>
				<AccountBalance currCode="UYI">123456.00</AccountBalance>
				<AccountAverage currCode="UYI">8288.64</AccountAverage>
			</AccountReport>
		</ReportingGroup>
	</CrsBody>
		 */
		
		
		
		return parent;
	}
}
