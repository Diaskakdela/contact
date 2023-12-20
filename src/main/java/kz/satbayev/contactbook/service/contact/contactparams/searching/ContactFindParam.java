package kz.satbayev.contactbook.service.contact.contactparams.searching;


import kz.satbayev.contactbook.service.contact.contactparams.ContactSearchType;
import lombok.Getter;

import static kz.satbayev.contactbook.service.contact.contactparams.ContactSearchType.BY_FULL_NAME;
import static kz.satbayev.contactbook.service.contact.contactparams.ContactSearchType.BY_PHONE;

@Getter
public class ContactFindParam {
    private String fullName;
    private String phone;
    private final ContactSearchType searchType;

    private ContactFindParam(String firstName, String lastName) {
        fullName = firstName.trim() + " " + lastName.trim();
        this.searchType = BY_FULL_NAME;
    }

    private ContactFindParam(String phoneNumber) {
        phone = phoneNumber.trim();
        this.searchType = BY_PHONE;
    }

    public static ContactFindParam createByName(String firstName, String lastName) {
        return new ContactFindParam(firstName, lastName);
    }

    public static ContactFindParam createByPhone(String phone) {
        return new ContactFindParam(phone);
    }
}
