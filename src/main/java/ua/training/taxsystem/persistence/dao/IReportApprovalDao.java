package ua.training.taxsystem.persistence.dao;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import ua.training.taxsystem.persistence.entities.ReportApproval;
import ua.training.taxsystem.persistence.entities.StateApproval;
import ua.training.taxsystem.persistence.entities.User;

public interface IReportApprovalDao extends IDao<ReportApproval> {
    Page<ReportApproval> findAllByUser(User user, Pageable pageable);
    Long countAllByUser(User user);
    Long countAllByStateApproval(StateApproval stateApproval);
    Long countAllByStateApprovalAndInspector(StateApproval stateApproval, User user);
    Page<ReportApproval> findAllByStateApproval(StateApproval stateApproval, Pageable pageable);
    Page<ReportApproval> findAllByStateApprovalAndInspector(StateApproval stateApproval, User inspector, Pageable pageable);
}
