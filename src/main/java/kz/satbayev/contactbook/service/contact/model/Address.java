package kz.satbayev.contactbook.service.contact.model;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class Address {
    private String country;
    private String city;
    private String street;
    private String building;
    private String apartment;
    private String index;
}
