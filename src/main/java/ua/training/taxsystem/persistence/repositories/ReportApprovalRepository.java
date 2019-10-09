package ua.training.taxsystem.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.training.taxsystem.persistence.entities.ReportApproval;

public interface ReportApprovalRepository extends JpaRepository<ReportApproval, Long> {

}
