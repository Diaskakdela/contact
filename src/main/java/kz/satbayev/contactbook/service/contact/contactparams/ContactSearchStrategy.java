package kz.satbayev.contactbook.service.contact.contactparams;

import kz.satbayev.contactbook.entity.ContactEntity;

import java.util.Optional;

public interface ContactSearchStrategy {
    boolean supports(ContactSearchType type);

    Optional<ContactEntity> findContact(ContactFindParam param);

    void deleteContact(ContactFindParam param);
}
