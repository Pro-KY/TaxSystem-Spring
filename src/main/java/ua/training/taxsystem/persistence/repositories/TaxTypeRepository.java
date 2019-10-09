package ua.training.taxsystem.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.training.taxsystem.persistence.entities.TaxType;

import java.util.Optional;

public interface TaxTypeRepository extends JpaRepository<TaxType, Long> {
    Optional<TaxType> findByType(String type);
}
