package co.edu.cesde.training.infrastructure.persistence;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "certifications")
public class CertificationJpaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long enrollmentId;

    private Long employeeId;

    private String programName;

    private LocalDate issueDate;

    private String verificationCode;

    public CertificationJpaEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getEnrollmentId() {
        return enrollmentId;
    }

    public void setEnrollmentId(Long enrollmentId) {
        this.enrollmentId = enrollmentId;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public String getProgramName() {
        return programName;
    }

    public void setProgramName(String programName) {
        this.programName = programName;
    }

    public LocalDate getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(LocalDate issueDate) {
        this.issueDate = issueDate;
    }

    public String getVerificationCode() {
        return verificationCode;
    }

    public void setVerificationCode(
            String verificationCode
    ) {
        this.verificationCode = verificationCode;
    }
}