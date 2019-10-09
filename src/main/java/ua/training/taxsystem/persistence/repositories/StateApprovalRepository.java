package ua.training.taxsystem.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.training.taxsystem.persistence.entities.StateApproval;

public interface StateApprovalRepository extends JpaRepository<StateApproval, Long> {

}
