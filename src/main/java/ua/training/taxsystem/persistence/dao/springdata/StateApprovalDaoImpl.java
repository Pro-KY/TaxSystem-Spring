package ua.training.taxsystem.persistence.dao.springdata;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import ua.training.taxsystem.persistence.dao.IStateApprovalDao;
import ua.training.taxsystem.persistence.entities.StateApproval;
import ua.training.taxsystem.persistence.repositories.StateApprovalRepository;

import java.util.Optional;

@Repository
@AllArgsConstructor
public class StateApprovalDaoImpl implements IStateApprovalDao {
    private final StateApprovalRepository repository;

    public Optional<StateApproval> findByState(String state) {
        return repository.findByState(state);
    }

    @Override
    public StateApproval save(StateApproval entity) {
        return repository.save(entity);
    }

    @Override
    public StateApproval update(StateApproval entity) {
        return repository.save(entity);
    }

    @Override
    public void delete(StateApproval entity) {
        repository.delete(entity);
    }

    @Override
    public Optional<StateApproval> findById(Long id) {
        return repository.findById(id);
    }
}
