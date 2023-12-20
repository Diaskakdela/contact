package kz.satbayev.contactbook.service.contact.mapper.dto;

import kz.satbayev.contactbook.service.contact.dto.AddressDto;
import kz.satbayev.contactbook.service.contact.dto.ContactDto;
import kz.satbayev.contactbook.service.contact.model.Address;
import kz.satbayev.contactbook.service.contact.model.Contact;

public class ContactDtoMapper {

    public static ContactDto toDto(Contact contact) {
        return new ContactDto()
                .setFullName(contact.getFullname())
                .setEmail(contact.getEmail())
                .setPhoneNumber(contact.getPhoneNumber())
                .setAddress(AddressDtoMapper.toDto(contact.getAddress()));
    }
}
