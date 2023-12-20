package kz.satbayev.contactbook.service.contact.mapper;

import kz.satbayev.contactbook.entity.AddressEmbedded;
import kz.satbayev.contactbook.entity.ContactEntity;
import kz.satbayev.contactbook.service.contact.model.Address;
import kz.satbayev.contactbook.service.contact.model.Contact;

public class ContactMapper {
    public static Contact toContact(ContactEntity contact){
        return new Contact()
                .setFullname(contact.getFullName())
                .setPhoneNumber(contact.getPhoneNumber())
                .setEmail(contact.getEmail())
                .setAddress(toAddress(contact.getAddressEmbedded()));
    }

    private static Address toAddress(AddressEmbedded addressEmbedded){
        return new Address()
                .setCountry(addressEmbedded.getCountry())
                .setCity(addressEmbedded.getCity())
                .setStreet(addressEmbedded.getStreet())
                .setBuilding(addressEmbedded.getBuilding())
                .setApartment(addressEmbedded.getApartment())
                .setIndex(addressEmbedded.getIndex());
    }
}
