package kz.satbayev.contactbook.service.contact.model;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class Contact {
    private String fullName;
    private String phoneNumber;
    private String email;
    private Address address;
}
