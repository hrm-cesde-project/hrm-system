package co.edu.cesde.training.domain.model;

import java.time.LocalDate;

public class Certification {

    private Long id;
    private Long enrollmentId;
    private Long employeeId;
    private String programName;
    private LocalDate issueDate;
    private String verificationCode;

    public Certification() {}

    public Certification(Long id, Long enrollmentId, Long employeeId, String programName,
                         LocalDate issueDate, String verificationCode) {
        this.id = id;
        this.enrollmentId = enrollmentId;
        this.employeeId = employeeId;
        this.programName = programName;
        this.issueDate = issueDate;
        this.verificationCode = verificationCode;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getEnrollmentId() { return enrollmentId; }
    public void setEnrollmentId(Long enrollmentId) { this.enrollmentId = enrollmentId; }

    public Long getEmployeeId() { return employeeId; }
    public void setEmployeeId(Long employeeId) { this.employeeId = employeeId; }

    public String getProgramName() { return programName; }
    public void setProgramName(String programName) { this.programName = programName; }

    public LocalDate getIssueDate() { return issueDate; }
    public void setIssueDate(LocalDate issueDate) { this.issueDate = issueDate; }

    public String getVerificationCode() { return verificationCode; }
    public void setVerificationCode(String verificationCode) { this.verificationCode = verificationCode; }

    @Override
    public String toString() {
        return "Certification{" +
                "id=" + id +
                ", enrollmentId=" + enrollmentId +
                ", employeeId=" + employeeId +
                ", programName='" + programName + '\'' +
                ", issueDate=" + issueDate +
                ", verificationCode='" + verificationCode + '\'' +
                '}';
    }
}