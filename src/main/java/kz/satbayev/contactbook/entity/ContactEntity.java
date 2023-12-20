package kz.satbayev.contactbook.entity;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Entity
@Accessors(chain = true)
public class ContactEntity {
    @Id
    @GeneratedValue
    private Long id;
    private String fullName;
    private String phoneNumber;
    private String email;
    @Embedded
    private AddressEmbedded addressEmbedded;
}
