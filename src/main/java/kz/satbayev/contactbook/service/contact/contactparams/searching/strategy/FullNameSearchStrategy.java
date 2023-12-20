package kz.satbayev.contactbook.service.contact.contactparams.searching.strategy;

import kz.satbayev.contactbook.entity.ContactEntity;
import kz.satbayev.contactbook.repo.ContactRepository;
import kz.satbayev.contactbook.service.contact.contactparams.ContactSearchType;
import kz.satbayev.contactbook.service.contact.contactparams.searching.ContactFindParam;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static kz.satbayev.contactbook.service.contact.contactparams.ContactSearchType.BY_FULL_NAME;

@Service
@RequiredArgsConstructor
public class FullNameSearchStrategy implements ContactSearchStrategy{
    private final ContactRepository contactRepository;

    @Override
    public boolean supports(ContactSearchType type) {
        return type == BY_FULL_NAME;
    }

    @Override
    public Optional<ContactEntity> findContact(ContactFindParam param) {
        return contactRepository.findByFullName(param.getFullName());
    }

    @Override
    public void deleteContact(ContactFindParam param) {
        contactRepository.deleteByFullName(param.getFullName());
    }

}
