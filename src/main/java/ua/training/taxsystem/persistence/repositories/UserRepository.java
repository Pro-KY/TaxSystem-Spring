package ua.training.taxsystem.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.training.taxsystem.persistence.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
