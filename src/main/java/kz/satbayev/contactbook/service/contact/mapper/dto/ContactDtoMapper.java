package kz.satbayev.contactbook.service.contact.mapper.dto;

import kz.satbayev.contactbook.service.contact.dto.ContactDto;
import kz.satbayev.contactbook.service.contact.model.Contact;
import org.springframework.stereotype.Component;

@Component
public class ContactDtoMapper {

    public ContactDto toDto(Contact contact) {
        return new ContactDto()
                .setFullName(contact.getFullName())
                .setEmail(contact.getEmail())
                .setPhoneNumber(contact.getPhoneNumber())
                .setAddress(AddressDtoMapper.toDto(contact.getAddress()));
    }
}
