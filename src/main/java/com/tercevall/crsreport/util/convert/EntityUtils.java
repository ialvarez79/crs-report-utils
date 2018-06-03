package com.tercevall.crsreport.util.convert;

import com.tercevall.crsreport.input.entities.*;

import javax.xml.bind.JAXBElement;
import java.util.Calendar;

public class EntityUtils {
    public static AddressType buildFixAddressType(ObjectFactory objectFactory, OECDLegalAddressTypeEnumType legalAddressType, String city, CountryCodeType countryCode) {
        AddressType addressType = objectFactory.createAddressType();

        if (legalAddressType != null){
            addressType.setLegalAddressType(legalAddressType);
        }
        JAXBElement<CountryCodeType> countryCodeTypeElement = objectFactory.createAddressTypeCountryCode(countryCode);
        addressType.getContent().add(countryCodeTypeElement);
        AddressFixType addressFix = objectFactory.createAddressFixType();
        addressFix.setCity(city);
        JAXBElement<AddressFixType> addressFixTypeElement = objectFactory.createAddressTypeAddressFix(addressFix);
        addressType.getContent().add(addressFixTypeElement);
        return addressType;
    }

    public static MessageSpecType buildMessageSpec(ObjectFactory objectFactory, String sendingCompanyIn, CountryCodeType transmittingCountryCode, CountryCodeType receivingCountryCode, String messageRefId, CrsMessageTypeIndicEnumType messageTypeIndic, Calendar reportingPeriod, Calendar timeStamp) {
        MessageSpecType messageSpec = objectFactory.createMessageSpecType();
        messageSpec.setSendingCompanyIN(sendingCompanyIn);
        messageSpec.setTransmittingCountry(transmittingCountryCode);
        messageSpec.setReceivingCountry(receivingCountryCode);
        messageSpec.setMessageType(MessageTypeEnumType.CRS);
        messageSpec.setMessageRefId(messageRefId);
        messageSpec.setMessageTypeIndic(messageTypeIndic);
        messageSpec.setReportingPeriod(reportingPeriod);
        messageSpec.setTimestamp(timeStamp);
        return messageSpec;
    }

    public static CorrectableOrganisationPartyType buildCorrectableOrganisationPartyType(ObjectFactory objectFactory, CountryCodeType reportingFiResCountryCode, CountryCodeType reportingFiInIssuedByCountryCode, String reportingFiInType, String reportingFiInValue, OECDNameTypeEnumType reportingFiNameType, String reportingFiNameValue, OECDLegalAddressTypeEnumType reportingFiLegalAddressType, String reportingFiLegalAddressCity, CountryCodeType reportingFiLegalAddressCountryCode, OECDDocTypeIndicEnumType reportingFiDocTypeIndic, String reportingFiDocRefId) {
        CorrectableOrganisationPartyType reportingFi = objectFactory.createCorrectableOrganisationPartyType();

        reportingFi.getResCountryCode().add(reportingFiResCountryCode);
        OrganisationINType inType = objectFactory.createOrganisationINType();
        reportingFi.getIN().add(inType);
        inType.setIssuedBy(reportingFiInIssuedByCountryCode);
        inType.setINType(reportingFiInType);
        inType.setValue(reportingFiInValue);

        NameOrganisationType fiName = objectFactory.createNameOrganisationType();
        fiName.setNameType(reportingFiNameType);
        fiName.setValue(reportingFiNameValue);
        reportingFi.getName().add(fiName);

        AddressType addressType = buildFixAddressType(objectFactory, reportingFiLegalAddressType, reportingFiLegalAddressCity, reportingFiLegalAddressCountryCode);
        reportingFi.getAddress().add(addressType);

        DocSpecType reportingFIDocSpec = objectFactory.createDocSpecType();
        reportingFi.setDocSpec(reportingFIDocSpec);
        reportingFIDocSpec.setDocTypeIndic(reportingFiDocTypeIndic);
        reportingFIDocSpec.setDocRefId(reportingFiDocRefId);
        return reportingFi;
    }
}
