package kz.satbayev.contactbook.service.contact.contactparams;

import lombok.Getter;
import lombok.Setter;

import java.util.Optional;

@Setter
public class ContactUpdateParam {

    private String fullName;
    private String phoneNumber;
    private String email;
    private AddressParam address;

    public Optional<String> getFullName() {
        return Optional.ofNullable(fullName);
    }

    public Optional<String> getPhoneNumber() {
        return Optional.ofNullable(phoneNumber);
    }

    public Optional<String> getEmail() {
        return Optional.ofNullable(email);
    }

    public Optional<AddressParam> getAddress() {
        return Optional.ofNullable(address);
    }
}
