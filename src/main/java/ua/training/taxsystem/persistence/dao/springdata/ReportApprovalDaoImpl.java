package ua.training.taxsystem.persistence.dao.springdata;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import ua.training.taxsystem.persistence.dao.IReportApprovalDao;
import ua.training.taxsystem.persistence.entities.ReportApproval;
import ua.training.taxsystem.persistence.entities.StateApproval;
import ua.training.taxsystem.persistence.entities.User;
import ua.training.taxsystem.persistence.repositories.ReportApprovalRepository;

import java.util.Optional;

@Repository
@AllArgsConstructor
public class ReportApprovalDaoImpl implements IReportApprovalDao {
    private final ReportApprovalRepository repository;

    @Override
    public Page<ReportApproval> findAllByUser(User user, Pageable pageable) {
        return repository.findAllByUser(user, pageable);
    }

    @Override
    public Long countAllByUser(User user) {
        return repository.countAllByUser(user);
    }

    @Override
    public Long countAllByStateApproval(StateApproval stateApproval) {
        return repository.countAllByStateApproval(stateApproval);
    }

    @Override
    public Long countAllByStateApprovalAndInspector(StateApproval stateApproval, User user) {
        return repository.countAllByStateApprovalAndInspector(stateApproval, user);
    }

    @Override
    public Page<ReportApproval> findAllByStateApproval(StateApproval stateApproval, Pageable pageable) {
        return repository.findAllByStateApproval(stateApproval, pageable);
    }

    @Override
    public Page<ReportApproval> findAllByStateApprovalAndInspector(StateApproval stateApproval, User inspector, Pageable pageable) {
        return repository.findAllByStateApprovalAndInspector(stateApproval, inspector, pageable);
    }

    @Override
    public ReportApproval save(ReportApproval entity) {
        return repository.save(entity);
    }

    @Override
    public ReportApproval update(ReportApproval entity) {
        return repository.save(entity);
    }

    @Override
    public void delete(ReportApproval entity) {
        repository.delete(entity);
    }

    @Override
    public Optional<ReportApproval> findById(Long id) {
        return repository.findById(id);
    }
}
