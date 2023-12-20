package kz.satbayev.contactbook.service.contact;


import kz.satbayev.contactbook.service.contact.contactparams.ContactCreationParam;
import kz.satbayev.contactbook.service.contact.contactparams.ContactFindParam;
import kz.satbayev.contactbook.service.contact.contactparams.ContactUpdateParam;
import kz.satbayev.contactbook.service.contact.dto.ContactDto;

import java.util.List;

public interface ContactService {
    void add(ContactCreationParam param);

    void remove(ContactFindParam param);

    void update(ContactFindParam findParam, ContactUpdateParam updateParam);

    ContactDto find(ContactFindParam param);

    List<ContactDto> findAllAlphabetically();
}
