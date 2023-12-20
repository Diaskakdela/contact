package kz.satbayev.contactbook.service.contact.contactparams;

import lombok.Getter;
import lombok.Setter;

import java.util.Optional;

@Getter
@Setter
public class AddressParam {
    private Optional<String> country;
    private Optional<String> city;
    private Optional<String> street;
    private Optional<String> building;
    private Optional<String> apartment;
    private Optional<String> index;
}
