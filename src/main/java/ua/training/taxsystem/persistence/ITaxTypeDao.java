package ua.training.taxsystem.persistence;

import ua.training.taxsystem.persistence.entities.TaxType;

import java.util.List;
import java.util.Optional;

public interface ITaxTypeDao extends IDao<TaxType> {
    Optional<TaxType> getTaxTypeByType(TaxType taxType);

    List<TaxType> getAllTaxTypes();
}
