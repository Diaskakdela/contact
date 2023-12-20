package kz.satbayev.contactbook.service.contact.contactparams.searching.strategy;

import kz.satbayev.contactbook.entity.ContactEntity;
import kz.satbayev.contactbook.repo.ContactRepository;
import kz.satbayev.contactbook.service.contact.contactparams.ContactSearchType;
import kz.satbayev.contactbook.service.contact.contactparams.searching.ContactFindParam;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static kz.satbayev.contactbook.service.contact.contactparams.ContactSearchType.BY_PHONE;

@Service
@RequiredArgsConstructor
public class PhoneSearchStrategy implements ContactSearchStrategy{
    private final ContactRepository contactRepository;

    @Override
    public boolean supports(ContactSearchType type) {
        return type==BY_PHONE;
    }

    @Override
    public Optional<ContactEntity> findContact(ContactFindParam param) {
        return contactRepository.findByPhoneNumber(param.getPhone());
    }

    @Override
    public void deleteContact(ContactFindParam param) {
        contactRepository.deleteByPhoneNumber(param.getPhone());
    }
}
