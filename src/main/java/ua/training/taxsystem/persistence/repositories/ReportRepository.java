package ua.training.taxsystem.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.training.taxsystem.persistence.entities.Report;

public interface ReportRepository extends JpaRepository<Report, Long> {

}
