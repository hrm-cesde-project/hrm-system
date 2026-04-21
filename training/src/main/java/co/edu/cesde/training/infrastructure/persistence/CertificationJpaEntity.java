package co.edu.cesde.training.infrastructure.persistence;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.time.LocalDate;

@Entity
public class CertificationJpaEntity {

    @Id
    private Long id;

    private Long enrollmentId;
    private Long employeeId;
    private String programName;
    private LocalDate issueDate;
    private String verificationCode;
}