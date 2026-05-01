package co.edu.cesde.training.domain.model;

import co.edu.cesde.training.domain.enums.EnrollmentStatus;

import java.time.LocalDate;

public class Enrollment {

    private Long id;
    private Long employeeId;
    private String employeeName;
    private Long programId;
    private EnrollmentStatus enrollmentStatus;
    private LocalDate registrationDate;
    private Double progressPercentage;
    private Double finalGrade;

    public Enrollment() {}

    public Enrollment(Long id, Long employeeId, String employeeName, Long programId,
                      EnrollmentStatus enrollmentStatus, LocalDate registrationDate,
                      Double progressPercentage, Double finalGrade) {
        this.id = id;
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.programId = programId;
        this.enrollmentStatus = enrollmentStatus;
        this.registrationDate = registrationDate;
        this.progressPercentage = progressPercentage;
        this.finalGrade = finalGrade;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getEmployeeId() { return employeeId; }
    public void setEmployeeId(Long employeeId) { this.employeeId = employeeId; }

    public String getEmployeeName() { return employeeName; }
    public void setEmployeeName(String employeeName) { this.employeeName = employeeName; }

    public Long getProgramId() { return programId; }
    public void setProgramId(Long programId) { this.programId = programId; }

    public EnrollmentStatus getEnrollmentStatus() { return enrollmentStatus; }
    public void setEnrollmentStatus(EnrollmentStatus enrollmentStatus) { this.enrollmentStatus = enrollmentStatus; }

    public LocalDate getRegistrationDate() { return registrationDate; }
    public void setRegistrationDate(LocalDate registrationDate) { this.registrationDate = registrationDate; }

    public Double getProgressPercentage() { return progressPercentage; }
    public void setProgressPercentage(Double progressPercentage) { this.progressPercentage = progressPercentage; }

    public Double getFinalGrade() { return finalGrade; }
    public void setFinalGrade(Double finalGrade) { this.finalGrade = finalGrade; }

    @Override
    public String toString() {
        return "Enrollment{" +
                "id=" + id +
                ", employeeId=" + employeeId +
                ", employeeName='" + employeeName + '\'' +
                ", programId=" + programId +
                ", enrollmentStatus=" + enrollmentStatus +
                ", registrationDate=" + registrationDate +
                ", progressPercentage=" + progressPercentage +
                ", finalGrade=" + finalGrade +
                '}';
    }
}