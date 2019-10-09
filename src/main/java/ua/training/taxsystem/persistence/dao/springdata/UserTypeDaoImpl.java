package ua.training.taxsystem.persistence.dao.springdata;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import ua.training.taxsystem.persistence.dao.ITaxTypeDao;
import ua.training.taxsystem.persistence.dao.IUserTypeDao;
import ua.training.taxsystem.persistence.entities.TaxType;
import ua.training.taxsystem.persistence.entities.UserType;
import ua.training.taxsystem.persistence.repositories.TaxTypeRepository;
import ua.training.taxsystem.persistence.repositories.UserRepository;
import ua.training.taxsystem.persistence.repositories.UserTypeRepository;

import java.util.List;
import java.util.Optional;

@Repository
@AllArgsConstructor
public class UserTypeDaoImpl implements IUserTypeDao {
    private final UserTypeRepository repository;

    @Override
    public Optional<UserType> findByType(String type) {
        return repository.findByType(type);
    }

    @Override
    public UserType save(UserType entity) {
        return repository.save(entity);
    }

    @Override
    public UserType update(UserType entity) {
        return repository.save(entity);
    }

    @Override
    public void delete(UserType entity) {
        repository.delete(entity);
    }

    @Override
    public Optional<UserType> findById(Long id) {
        return repository.findById(id);
    }
}
