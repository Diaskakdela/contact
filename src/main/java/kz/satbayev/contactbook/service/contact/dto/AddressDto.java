package kz.satbayev.contactbook.service.contact.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
public class AddressDto {
    private String country;
    private String city;
    private String street;
    private String building;
    private String apartment;
    private String index;
}
