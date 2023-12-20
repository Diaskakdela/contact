package kz.satbayev.contactbook.service.contact.impl;

import kz.satbayev.contactbook.entity.AddressEmbedded;
import kz.satbayev.contactbook.entity.ContactEntity;
import kz.satbayev.contactbook.exception.ContactException;
import kz.satbayev.contactbook.repo.ContactRepository;
import kz.satbayev.contactbook.service.contact.ContactService;
import kz.satbayev.contactbook.service.contact.contactparams.ContactSearchType;
import kz.satbayev.contactbook.service.contact.contactparams.StrategyDefiner;
import kz.satbayev.contactbook.service.contact.contactparams.creating.ContactCreationParam;
import kz.satbayev.contactbook.service.contact.contactparams.searching.ContactFindParam;
import kz.satbayev.contactbook.service.contact.contactparams.searching.strategy.ContactSearchStrategy;
import kz.satbayev.contactbook.service.contact.contactparams.ContactUpdateParam;
import kz.satbayev.contactbook.service.contact.dto.ContactDto;
import kz.satbayev.contactbook.service.contact.mapper.ContactMapper;
import kz.satbayev.contactbook.service.contact.mapper.dto.ContactDtoMapper;
import kz.satbayev.contactbook.service.contact.model.Contact;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DefaultContactService implements ContactService {

    private final ContactRepository contactRepository;
    private final StrategyDefiner strategyDefiner;

    @Override
    public void add(ContactCreationParam param) {
        var addressEmbedded = new AddressEmbedded()
                .setCountry(param.getAddress().getCountry())
                .setCity(param.getAddress().getCity())
                .setStreet(param.getAddress().getStreet())
                .setBuilding(param.getAddress().getBuilding())
                .setApartment(param.getAddress().getApartment())
                .setIndex(param.getAddress().getIndex());

        var contact = new ContactEntity()
                .setAddressEmbedded(addressEmbedded)
                .setEmail(param.getEmail())
                .setFullName(param.getFullName())
                .setPhoneNumber(param.getPhoneNumber());

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
        Contact contact = ContactMapper.toContact(findContactEntity(param));
        return ContactDtoMapper.toDto(contact);
    }

    private ContactEntity findContactEntity(ContactFindParam param){
        return strategyDefiner.defineStrategy(param)
                .findContact(param)
                .orElseThrow(()->new ContactException("contact not found"));
    }

    @Override
    public List<ContactDto> findAllAlphabetically() {
        return contactRepository.findAll()
                .stream()
                .map(ContactMapper::toContact)
                .map(ContactDtoMapper::toDto)
                .sorted(Comparator.comparing(ContactDto::getFullName))
                .toList();
    }
}
