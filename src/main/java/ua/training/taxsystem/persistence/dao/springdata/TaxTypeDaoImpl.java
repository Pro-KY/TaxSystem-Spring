package ua.training.taxsystem.persistence.dao.springdata;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import ua.training.taxsystem.persistence.dao.IStateApprovalDao;
import ua.training.taxsystem.persistence.dao.ITaxTypeDao;
import ua.training.taxsystem.persistence.entities.StateApproval;
import ua.training.taxsystem.persistence.entities.TaxType;
import ua.training.taxsystem.persistence.repositories.StateApprovalRepository;
import ua.training.taxsystem.persistence.repositories.TaxTypeRepository;

import java.util.List;
import java.util.Optional;

@Repository
@AllArgsConstructor
public class TaxTypeDaoImpl implements ITaxTypeDao {
    private final TaxTypeRepository repository;

    @Override
    public Optional<TaxType> findByType(String type) {
        return repository.findByType(type);
    }

    @Override
    public List<TaxType> findAll() {
        return repository.findAll();
    }

    @Override
    public TaxType save(TaxType entity) {
        return repository.save(entity);
    }

    @Override
    public TaxType update(TaxType entity) {
        return repository.save(entity);
    }

    @Override
    public void delete(TaxType entity) {
        repository.delete(entity);
    }

    @Override
    public Optional<TaxType> findById(Long id) {
        return repository.findById(id);
    }
}
