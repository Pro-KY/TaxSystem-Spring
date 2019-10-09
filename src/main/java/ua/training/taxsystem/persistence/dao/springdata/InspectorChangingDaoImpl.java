package ua.training.taxsystem.persistence.dao.springdata;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import ua.training.taxsystem.persistence.dao.IInspectorChangingDao;
import ua.training.taxsystem.persistence.entities.InspectorChanging;
import ua.training.taxsystem.persistence.repositories.InspectorChangingRepository;

import java.util.Optional;

@Repository
@AllArgsConstructor
public class InspectorChangingDaoImpl implements IInspectorChangingDao {
    private final InspectorChangingRepository repository;

    @Override
    public InspectorChanging save(InspectorChanging entity) {
        return repository.save(entity);
    }

    @Override
    public InspectorChanging update(InspectorChanging entity) {
        return repository.save(entity);
    }

    @Override
    public void delete(InspectorChanging entity) {
        repository.delete(entity);
    }

    @Override
    public Optional<InspectorChanging> findById(Long id) {
        return repository.findById(id);
    }
}
