package ua.training.taxsystem.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.training.taxsystem.persistence.entities.UserType;

public interface UserTypeRepository extends JpaRepository<UserType, Long> {

}
