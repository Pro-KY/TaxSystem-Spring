package ua.training.taxsystem.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.training.taxsystem.persistence.entities.TaxType;

public interface TaxTypeRepository extends JpaRepository<TaxType, Long> {

}
