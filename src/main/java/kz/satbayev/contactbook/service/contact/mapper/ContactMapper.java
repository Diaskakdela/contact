package kz.satbayev.contactbook.service.contact.mapper;

import kz.satbayev.contactbook.entity.AddressEmbedded;
import kz.satbayev.contactbook.entity.ContactEntity;
import kz.satbayev.contactbook.service.contact.contactparams.AddressCreationParam;
import kz.satbayev.contactbook.service.contact.contactparams.ContactCreationParam;
import kz.satbayev.contactbook.service.contact.model.Address;
import kz.satbayev.contactbook.service.contact.model.Contact;
import org.springframework.stereotype.Component;

@Component
public class ContactMapper {
    public Contact toContact(ContactEntity contact) {
        return new Contact()
                .setFullName(contact.getFullName())
                .setPhoneNumber(contact.getPhoneNumber())
                .setEmail(contact.getEmail())
                .setAddress(toAddress(contact.getAddressEmbedded()));
    }

    private Address toAddress(AddressEmbedded addressEmbedded) {
        return new Address()
                .setCountry(addressEmbedded.getCountry())
                .setCity(addressEmbedded.getCity())
                .setStreet(addressEmbedded.getStreet())
                .setBuilding(addressEmbedded.getBuilding())
                .setApartment(addressEmbedded.getApartment())
                .setIndex(addressEmbedded.getIndex());
    }

    public ContactEntity toContactEntity(ContactCreationParam param) {
        if (isBlank(param.getEmail()) || isBlank(param.getFullName()) || isBlank(param.getPhoneNumber())) {
            throw new IllegalArgumentException("Email, full name, and phone number must not be empty");
        }
        return new ContactEntity()
                .setAddressEmbedded(toAddressEmbedded(param.getAddress()))
                .setEmail(param.getEmail())
                .setFullName(param.getFullName())
                .setPhoneNumber(param.getPhoneNumber());
    }

    private AddressEmbedded toAddressEmbedded(AddressCreationParam param) {
        return new AddressEmbedded()
                .setCountry(param.getCountry())
                .setCity(param.getCity())
                .setStreet(param.getStreet())
                .setBuilding(param.getBuilding())
                .setApartment(param.getApartment())
                .setIndex(param.getIndex());
    }

    private boolean isBlank(String str) {
        return str == null || str.trim().isEmpty();
    }
}
