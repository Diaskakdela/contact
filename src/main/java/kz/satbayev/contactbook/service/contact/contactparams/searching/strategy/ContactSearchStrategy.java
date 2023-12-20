package kz.satbayev.contactbook.service.contact.contactparams.searching.strategy;

import kz.satbayev.contactbook.entity.ContactEntity;
import kz.satbayev.contactbook.service.contact.contactparams.ContactSearchType;
import kz.satbayev.contactbook.service.contact.contactparams.searching.ContactFindParam;

import java.util.Optional;

public interface ContactSearchStrategy {
    boolean supports(ContactSearchType type);
    Optional<ContactEntity> findContact(ContactFindParam param);

    void deleteContact(ContactFindParam param);
}
