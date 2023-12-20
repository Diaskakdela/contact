package kz.satbayev.contactbook.service.contact.contactparams;

import lombok.Getter;
import lombok.Setter;

import java.util.Optional;

@Setter
public class AddressParam {
    private String country;
    private String city;
    private String street;
    private String building;
    private String apartment;
    private String index;

    public Optional<String> getCountry() {
        return Optional.ofNullable(country);
    }

    public Optional<String> getCity() {
        return Optional.ofNullable(city);
    }

    public Optional<String> getStreet() {
        return Optional.ofNullable(street);
    }

    public Optional<String> getBuilding() {
        return Optional.ofNullable(building);
    }

    public Optional<String> getApartment() {
        return Optional.ofNullable(apartment);
    }

    public Optional<String> getIndex() {
        return Optional.ofNullable(index);
    }
}
