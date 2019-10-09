package ua.training.taxsystem.persistence.dao;

import ua.training.taxsystem.persistence.entities.User;
import ua.training.taxsystem.persistence.entities.UserType;

import java.util.List;
import java.util.Optional;

public interface IUserDao extends IDao<User> {
    Optional<User> getUserByEmailAndPassword(String login, String password);
    List<User> findAllByUserTypeAndIdNotEqual(UserType userType, Long id);
}
