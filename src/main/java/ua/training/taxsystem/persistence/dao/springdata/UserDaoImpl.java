package ua.training.taxsystem.persistence.dao.springdata;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import ua.training.taxsystem.persistence.dao.IUserDao;
import ua.training.taxsystem.persistence.dao.IUserTypeDao;
import ua.training.taxsystem.persistence.entities.User;
import ua.training.taxsystem.persistence.entities.UserType;
import ua.training.taxsystem.persistence.repositories.UserRepository;
import ua.training.taxsystem.persistence.repositories.UserTypeRepository;

import java.util.List;
import java.util.Optional;

@Repository
@AllArgsConstructor
public class UserDaoImpl implements IUserDao {
    private final UserRepository repository;

    @Override
    public Optional<User> findUserByEmailAndPassword(String email, String password) {
        return repository.findByEmailAndPassword(email, password);
    }

    @Override
    public List<User> findAllByUserTypeAndIdNotEqual(UserType userType, Long id) {
        return repository.findAllByUserTypeAndIdIsNot(userType, id);
    }

    @Override
    public User save(User entity) {
        return repository.save(entity);
    }

    @Override
    public User update(User entity) {
        return repository.save(entity);
    }

    @Override
    public void delete(User entity) {
        repository.delete(entity);
    }

    @Override
    public Optional<User> findById(Long id) {
        return repository.findById(id);
    }
}
