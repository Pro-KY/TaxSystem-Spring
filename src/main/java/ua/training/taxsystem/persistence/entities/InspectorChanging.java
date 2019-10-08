package ua.training.taxsystem.persistence.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "inspector_changing", schema = "tax_system")
@Data
@NoArgsConstructor
public class InspectorChanging {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "timestamp")
    private Timestamp timestamp;

    @ManyToOne
    @JoinColumn(name = "report_approval_id")
    private ReportApproval reportApproval;

    @OneToOne
    @JoinColumn(name = "previous_inspector_id")
    private User previousInspector;
}
