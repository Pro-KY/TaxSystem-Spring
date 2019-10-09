package ua.training.taxsystem.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.training.taxsystem.persistence.entities.User;
import ua.training.taxsystem.persistence.entities.UserType;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findAllByUserTypeAndIdIsNot(UserType userType, Long id);
    Optional<User> findByEmailAndPassword(String email, String password);

}
