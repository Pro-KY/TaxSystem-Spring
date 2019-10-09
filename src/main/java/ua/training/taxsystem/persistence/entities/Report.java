package ua.training.taxsystem.persistence.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Entity
@Table(name = "report", schema = "tax_system")
@Data
@NoArgsConstructor
public class Report {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "sum")
    private Double sum;

    @Column(name = "quarter")
    private Integer quarter;

    @OneToOne
    @JoinColumn(name = "tax_type_id")
    private TaxType taxType;
}
