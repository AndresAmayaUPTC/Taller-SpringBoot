package co.uptc.Taller.SpringBoot.repositories;

import co.uptc.Taller.SpringBoot.entities.Owner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OwnerRepository extends JpaRepository<Owner, Integer> {
}
