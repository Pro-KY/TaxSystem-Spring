package ua.training.taxsystem.persistence.dao.springdata;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import ua.training.taxsystem.persistence.dao.IReportDao;
import ua.training.taxsystem.persistence.dao.IStateApprovalDao;
import ua.training.taxsystem.persistence.entities.Report;
import ua.training.taxsystem.persistence.entities.StateApproval;
import ua.training.taxsystem.persistence.repositories.ReportRepository;
import ua.training.taxsystem.persistence.repositories.StateApprovalRepository;

import java.util.Optional;

@Repository
@AllArgsConstructor
public class ReportDaoImpl implements IReportDao {
    private final ReportRepository repository;

    @Override
    public Report save(Report entity) {
        return repository.save(entity);
    }

    @Override
    public Report update(Report entity) {
        return repository.save(entity);
    }

    @Override
    public void delete(Report entity) {
        repository.delete(entity);
    }

    @Override
    public Optional<Report> findById(Long id) {
        return repository.findById(id);
    }
}
