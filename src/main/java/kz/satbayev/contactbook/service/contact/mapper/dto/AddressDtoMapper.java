package kz.satbayev.contactbook.service.contact.mapper.dto;

import kz.satbayev.contactbook.service.contact.dto.AddressDto;
import kz.satbayev.contactbook.service.contact.model.Address;

public class AddressDtoMapper {
    public static AddressDto toDto(Address address){
        return new AddressDto()
                .setCountry(address.getCountry())
                .setCity(address.getCity())
                .setStreet(address.getStreet())
                .setBuilding(address.getBuilding())
                .setApartment(address.getApartment())
                .setIndex(address.getIndex());
    }
}
