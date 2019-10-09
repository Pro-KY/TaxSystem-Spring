package ua.training.taxsystem.persistence;


import ua.training.taxsystem.persistence.entities.StateApproval;

import java.util.Optional;

public interface IStateApprovalDao extends IDao<StateApproval> {
    Optional<StateApproval> findByState(String state);
}
