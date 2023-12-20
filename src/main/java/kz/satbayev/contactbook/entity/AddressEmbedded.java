package kz.satbayev.contactbook.entity;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Embeddable
@Getter
@Setter
@Accessors(chain = true)
public class AddressEmbedded {
    private String country;
    private String city;
    private String street;
    private String building;
    private String apartment;
    private String index;
}
