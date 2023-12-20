package kz.satbayev.contactbook.controller;

import kz.satbayev.contactbook.service.contact.contactparams.ContactUpdateParam;
import kz.satbayev.contactbook.service.contact.contactparams.searching.ContactFindParam;
import lombok.Data;

@Data
public class UpdateContactDto {
    private ContactFindParam findParam;
    private ContactUpdateParam updateParam;
}
