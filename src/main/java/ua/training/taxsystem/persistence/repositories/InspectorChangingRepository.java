package ua.training.taxsystem.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.training.taxsystem.persistence.entities.InspectorChanging;

public interface InspectorChangingRepository extends JpaRepository<InspectorChanging, Long> {

}
