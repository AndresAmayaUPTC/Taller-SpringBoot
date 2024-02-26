package co.uptc.Taller.SpringBoot.repositories;


import co.uptc.Taller.SpringBoot.entities.Phone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhoneRepository extends JpaRepository<Phone, Long> {
}
