package ua.training.taxsystem.persistence.dao;



import ua.training.taxsystem.persistence.entities.UserType;

import java.util.Optional;

public interface IUserTypeDao extends IDao<UserType> {
    Optional<UserType> findByType(String type);
}
