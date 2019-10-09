package ua.training.taxsystem.persistence.dao.springdata;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Repository;
import ua.training.taxsystem.persistence.dao.IReportApprovalDao;
import ua.training.taxsystem.persistence.entities.ReportApproval;
import ua.training.taxsystem.persistence.entities.StateApproval;
import ua.training.taxsystem.persistence.entities.User;
import ua.training.taxsystem.persistence.repositories.ReportApprovalRepository;

import java.util.List;
import java.util.Optional;

@Repository
@AllArgsConstructor
public class ReportApprovalDaoImpl implements IReportApprovalDao {
    private final ReportApprovalRepository repository;

    @Override
    public Page<ReportApproval> findAllByUser(User user, Page page) {
        return null;
    }

    @Override
    public Long countAllByUser(User user) {
        return null;
    }

    @Override
    public Long countAllByStateApproval(StateApproval stateApproval) {
        return null;
    }

    @Override
    public Long countAllByStateApprovalAndInspector(StateApproval stateApproval, User user) {
        return null;
    }

    @Override
    public Page<ReportApproval> findAllByStateApproval(StateApproval stateApproval, Page page) {
        return null;
    }

    @Override
    public Page<ReportApproval> findAllByStateApprovalAndInspector(StateApproval stateApproval, User inspector, Page page) {
        return null;
    }

    @Override
    public ReportApproval save(ReportApproval entity) {
        return null;
    }

    @Override
    public ReportApproval update(ReportApproval entity) {
        return null;
    }

    @Override
    public void delete(ReportApproval entity) {

    }

    @Override
    public Optional<ReportApproval> findById(Long id) {
        return Optional.empty();
    }
}
