package ua.training.taxsystem.persistence.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "report_approval", schema = "tax_system")
@Data
@NoArgsConstructor
public class ReportApproval {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "timestamp")
    private Timestamp timestamp;

    @Column(name = "refusal_cause")
    private String refusalCause;

    @OneToOne
    @JoinColumn(name = "state_approval_id")
    private StateApproval stateApproval;

    @OneToOne
    @JoinColumn(name = "report_id")
    private Report report;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "inspector_id")
    private User inspector;
}
