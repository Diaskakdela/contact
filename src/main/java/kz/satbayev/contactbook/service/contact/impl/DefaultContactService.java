package kz.satbayev.contactbook.service.contact.impl;

import kz.satbayev.contactbook.entity.ContactEntity;
import kz.satbayev.contactbook.exception.ContactNotFoundException;
import kz.satbayev.contactbook.repo.ContactRepository;
import kz.satbayev.contactbook.service.contact.ContactService;
import kz.satbayev.contactbook.service.contact.contactparams.StrategyDefiner;
import kz.satbayev.contactbook.service.contact.contactparams.ContactCreationParam;
import kz.satbayev.contactbook.service.contact.contactparams.ContactFindParam;
import kz.satbayev.contactbook.service.contact.contactparams.ContactUpdateParam;
import kz.satbayev.contactbook.service.contact.dto.ContactDto;
import kz.satbayev.contactbook.service.contact.mapper.ContactMapper;
import kz.satbayev.contactbook.service.contact.mapper.dto.ContactDtoMapper;
import kz.satbayev.contactbook.service.contact.model.Contact;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DefaultContactService implements ContactService {

    private final ContactRepository contactRepository;
    private final StrategyDefiner strategyDefiner;
    private final ContactMapper contactMapper;
    private final ContactDtoMapper contactDtoMapper;

    @Override
    public void add(ContactCreationParam param) {
        if (param == null || param.getAddress() == null) {
            throw new IllegalArgumentException("param or address is null");
        }
        var contact = contactMapper.toContactEntity(param);

        contactRepository.save(contact);
    }

    @Override
    public void remove(ContactFindParam param) {
        strategyDefiner.defineStrategy(param).deleteContact(param);
    }

    @Override
    public void update(ContactFindParam findParam, ContactUpdateParam updateParam) {
        var contactEntity = findContactEntity(findParam);
        var addressEntity = contactEntity.getAddressEmbedded();

        updateParam.getPhoneNumber().ifPresent(contactEntity::setPhoneNumber);
        updateParam.getEmail().ifPresent(contactEntity::setEmail);
        updateParam.getFullName().ifPresent(contactEntity::setFullName);

        updateParam.getAddress().ifPresent(addressParam -> {
            addressParam.getCountry().ifPresent(addressEntity::setCountry);
            addressParam.getCity().ifPresent(addressEntity::setCity);
            addressParam.getStreet().ifPresent(addressEntity::setStreet);
            addressParam.getBuilding().ifPresent(addressEntity::setBuilding);
            addressParam.getApartment().ifPresent(addressEntity::setApartment);
        });

        contactRepository.save(contactEntity);
    }

    @Override
    public ContactDto find(ContactFindParam param) {
        Contact contact = contactMapper.toContact(findContactEntity(param));
        return contactDtoMapper.toDto(contact);
    }

    private ContactEntity findContactEntity(ContactFindParam param) {
        return strategyDefiner.defineStrategy(param)
                .findContact(param)
                .orElseThrow(() -> new ContactNotFoundException("contact not found"));
    }

    @Override
    public List<ContactDto> findAllAlphabetically() {
        return contactRepository.findAllByOrderByFullName()
                .stream()
                .map(contactMapper::toContact)
                .map(contactDtoMapper::toDto)
                .toList();
    }
}
