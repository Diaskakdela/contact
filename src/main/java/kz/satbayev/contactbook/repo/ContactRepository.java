package kz.satbayev.contactbook.repo;

import kz.satbayev.contactbook.entity.ContactEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ContactRepository extends JpaRepository<ContactEntity, Long> {
    void deleteByFullName(String fullName);
    void deleteByPhoneNumber(String phoneNumber);

    Optional<ContactEntity> findByPhoneNumber(String phoneNumber);
    Optional<ContactEntity> findByFullName(String phoneNumber);

    List<ContactEntity> findAllByOrderByFullName();
}
