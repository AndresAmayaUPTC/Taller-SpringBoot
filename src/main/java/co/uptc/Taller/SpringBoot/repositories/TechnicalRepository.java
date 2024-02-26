package co.uptc.Taller.SpringBoot.repositories;

import co.uptc.Taller.SpringBoot.entities.Technical;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TechnicalRepository extends JpaRepository<Technical, Integer> {
}
