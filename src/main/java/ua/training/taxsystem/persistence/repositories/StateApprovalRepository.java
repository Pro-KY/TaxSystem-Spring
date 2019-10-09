package ua.training.taxsystem.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.training.taxsystem.persistence.entities.StateApproval;

import java.util.Optional;

public interface StateApprovalRepository extends JpaRepository<StateApproval, Long> {
    Optional<StateApproval> findByState(String state);
}
