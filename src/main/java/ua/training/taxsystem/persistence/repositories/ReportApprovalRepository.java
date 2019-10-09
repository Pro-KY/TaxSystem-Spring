package ua.training.taxsystem.persistence.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import ua.training.taxsystem.persistence.entities.ReportApproval;
import ua.training.taxsystem.persistence.entities.StateApproval;
import ua.training.taxsystem.persistence.entities.User;

public interface ReportApprovalRepository extends JpaRepository<ReportApproval, Long> {
    Page<ReportApproval> findAllByUser(User user, Pageable pageable);
    Page<ReportApproval> findAllByStateApproval(StateApproval stateApproval, Pageable pageable);
    Page<ReportApproval> findAllByStateApprovalAndInspector(StateApproval stateApproval, User inspector, Pageable pageable);

    Long countAllByUser(User user);
    Long countAllByStateApproval(StateApproval stateApproval);
    Long countAllByStateApprovalAndInspector(StateApproval stateApproval, User inspector);


}
