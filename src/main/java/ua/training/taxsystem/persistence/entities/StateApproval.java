package ua.training.taxsystem.persistence.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "state_approval", schema = "tax_system")
@Data
@NoArgsConstructor
public class StateApproval {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "state")
    private String state;

    public StateApproval(Long id) {
        this.id = id;
    }
}
