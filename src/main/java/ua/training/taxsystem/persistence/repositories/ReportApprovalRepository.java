package ua.training.taxsystem.persistence.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import ua.training.taxsystem.persistence.entities.ReportApproval;
import ua.training.taxsystem.persistence.entities.User;

import java.util.List;

public interface ReportApprovalRepository extends JpaRepository<ReportApproval, Long> {
    Page<ReportApproval> findAllByUser(User user, Pageable pageable);

}
