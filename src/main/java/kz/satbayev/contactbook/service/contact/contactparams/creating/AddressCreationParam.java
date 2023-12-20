package kz.satbayev.contactbook.service.contact.contactparams.creating;

import lombok.Data;

@Data
public class AddressCreationParam {
    private String country;
    private String city;
    private String street;
    private String building;
    private String apartment;
    private String index;
}
