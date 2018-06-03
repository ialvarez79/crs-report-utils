package com.tercevall.crsreport;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import com.tercevall.crsreport.input.entities.*;
import com.tercevall.crsreport.util.convert.EntityUtils;

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
		*/
		CrsBodyType crsBody = objectFactory.createCrsBodyType();
		List<CrsBodyType> parentBodies = parent.getCrsBody();
		parentBodies.add(crsBody);

		CorrectableOrganisationPartyType reportingFi = objectFactory.createCorrectableOrganisationPartyType();
		crsBody.setReportingFI(reportingFi);

		reportingFi.getResCountryCode().add(CountryCodeType.UY);
		OrganisationINType inType = objectFactory.createOrganisationINType();
		reportingFi.getIN().add(inType);
		inType.setIssuedBy(CountryCodeType.UY);
		inType.setINType("RUC");
		inType.setValue("210639630014");

		NameOrganisationType fiName = objectFactory.createNameOrganisationType();
		fiName.setNameType(OECDNameTypeEnumType.OECD_207);
		fiName.setValue("BHU");
		reportingFi.getName().add(fiName);

		//FIXME - NACHO - VER SI CONVIENE HACER UN UTILITARIO PARA SETEAR EL ADDRESS QUE CORRESPONDA
		OECDLegalAddressTypeEnumType legalAddressType = OECDLegalAddressTypeEnumType.OECD_301;
		String city = "Montevideo";
		CountryCodeType countryCode = CountryCodeType.UY;
		AddressType addressType = EntityUtils.createFixAddressType(objectFactory, legalAddressType, city, countryCode);
		reportingFi.getAddress().add(addressType);

		DocSpecType reportingFIDocSpec = objectFactory.createDocSpecType();
		reportingFi.setDocSpec(reportingFIDocSpec);
		reportingFIDocSpec.setDocTypeIndic(OECDDocTypeIndicEnumType.OECD_11);
		reportingFIDocSpec.setDocRefId("UY.210639630014.000000043");
		/*
		<ReportingGroup>
			<AccountReport>
				<DocSpec>
					<DocTypeIndic xmlns="urn:oecd:ties:stf:v4">OECD11</DocTypeIndic>
					<DocRefId xmlns="urn:oecd:ties:stf:v4">UY.210639630014.000000044</DocRefId>
				</DocSpec>
				<AccountNumber AcctNumberType="OECD602"
					UndocumentedAccount="false" ClosedAccount="false"
					PreexistingAccount="false" TopBalanceAccount="false">10-84-114313-0</AccountNumber>
		 */
		CrsBodyType.ReportingGroup reportingGroup = objectFactory.createCrsBodyTypeReportingGroup();
		crsBody.getReportingGroup().add(reportingGroup);

		CorrectableAccountReportType accountReport = objectFactory.createCorrectableAccountReportType();
		reportingGroup.getAccountReport().add(accountReport);
		DocSpecType accountReportDocSpecType = objectFactory.createDocSpecType();
		accountReportDocSpecType.setDocTypeIndic(OECDDocTypeIndicEnumType.OECD_11);
		//FIXME - NACHO - VER COMO SE OBTIENEN LOS DOC REF ID
		accountReportDocSpecType.setDocRefId("UY.210639630014.000000044");
		accountReport.setDocSpec(accountReportDocSpecType);

		FIAccountNumberType accountNumber = objectFactory.createFIAccountNumberType();
		accountReport.setAccountNumber(accountNumber);
		accountNumber.setAcctNumberType(AcctNumberTypeEnumType.OECD_602);
		accountNumber.setUndocumentedAccount(false);
		accountNumber.setClosedAccount(false);
		accountNumber.setPreexistingAccount(false);
		accountNumber.setTopBalanceAccount(false);
		accountNumber.setValue("10-84-114313-0");

/*
				<AccountHolder>
					<Individual>
						<ResCountryCode>CA</ResCountryCode>
						<TIN issuedBy="CA" INType="CI">45100134</TIN>
						<Name nameType="OECD202">
							<FirstName>TRILCE                        </FirstName>
							<LastName>GERVAZ              </LastName>
						</Name>
 */
		AccountHolderType accountHolder = objectFactory.createAccountHolderType();
		accountReport.setAccountHolder(accountHolder);
		PersonPartyType individual = objectFactory.createPersonPartyType();
		accountHolder.setIndividual(individual);
		individual.getResCountryCode().add(CountryCodeType.CA);
		TINType tin = objectFactory.createTINType();
		individual.getTIN().add(tin);
		tin.setIssuedBy(CountryCodeType.CA);
		tin.setINType("CI");
		tin.setValue("45100134");

		NamePersonType accountHolderName = objectFactory.createNamePersonType();
		individual.getName().add(accountHolderName);
		accountHolderName.setNameType(OECDNameTypeEnumType.OECD_202);
		NamePersonType.FirstName firstName = objectFactory.createNamePersonTypeFirstName();
		accountHolderName.setFirstName(firstName);
		firstName.setValue("TRILCE                        ");

		NamePersonType.LastName lastName = objectFactory.createNamePersonTypeLastName();
		accountHolderName.setLastName(lastName);
		lastName.setValue("GERVAZ              ");

		/*
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
		 */
		AddressType individualAddress = EntityUtils.createFixAddressType(objectFactory,null,"OTTAWA         ",CountryCodeType.UY);
		individual.getAddress().add(individualAddress);
		PersonPartyType.BirthInfo individualBirthInfo = objectFactory.createPersonPartyTypeBirthInfo();
		individual.setBirthInfo(individualBirthInfo);
		Calendar birthDate = Calendar.getInstance();
		birthDate.set(1991,01,12);
		individualBirthInfo.setBirthDate(birthDate);
		/*
						<AccountBalance currCode="UYI">123456.00</AccountBalance>
				<AccountAverage currCode="UYI">8288.64</AccountAverage>
			</AccountReport>
		</ReportingGroup>
	</CrsBody>
		 */
		MonAmntType accountBalance = objectFactory.createMonAmntType();
		accountReport.setAccountBalance(accountBalance);
		accountBalance.setCurrCode(CurrCodeType.UYI);
		accountBalance.setValue(new BigDecimal(123456.00));

		MonAmntType accountAverage = objectFactory.createMonAmntType();
		accountReport.setAccountAverage(accountAverage);
		accountAverage.setCurrCode(CurrCodeType.UYI);
		accountAverage.setValue(new BigDecimal(8288.64));
		return parent;
	}
}
