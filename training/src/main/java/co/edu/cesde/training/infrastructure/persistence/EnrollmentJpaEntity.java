package co.edu.cesde.training.infrastructure.persistence;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "enrollments")
public class EnrollmentJpaEntity {

    @Id
    private Long id;

    private Long employeeId;
    private Long programId;
    private String status;
    private Double progressPercentage;
    private Double finalGrade;
}