package kz.satbayev.contactbook.service.contact.contactparams;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ContactCreationParam {

    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    private AddressCreationParam address;

    public String getFullName() {
        return firstName.trim() + " " + lastName.trim();
    }
}
