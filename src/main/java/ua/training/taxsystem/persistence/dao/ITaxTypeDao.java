package ua.training.taxsystem.persistence.dao;

import ua.training.taxsystem.persistence.entities.TaxType;

import java.util.List;
import java.util.Optional;

public interface ITaxTypeDao extends IDao<TaxType> {
    Optional<TaxType> findByType(String type);
    List<TaxType> findAll();
}
