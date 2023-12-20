package kz.satbayev.contactbook.service.contact.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
public class ContactDto {
    private String fullName;
    private String phoneNumber;
    private String email;
    private AddressDto address;
}
