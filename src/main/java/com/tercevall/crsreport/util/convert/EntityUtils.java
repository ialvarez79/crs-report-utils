package com.tercevall.crsreport.util.convert;

import com.tercevall.crsreport.input.entities.*;

import javax.xml.bind.JAXBElement;

public class EntityUtils {
    public static AddressType createFixAddressType(ObjectFactory objectFactory, OECDLegalAddressTypeEnumType legalAddressType, String city, CountryCodeType countryCode) {
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

}
