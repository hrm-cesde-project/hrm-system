package co.edu.cesde.recruitment.application.dto;

import co.edu.cesde.recruitment.domain.enums.CandidateStatus;
import java.time.LocalDate;

import java.time.LocalDate;

public class CandidateDto {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private CandidateStatus status;
    private String appliedPosition;
    private LocalDate applicationDate;
    private String rejectionReason;

    public CandidateDto(Long id,
                        String firstName,
                        String lastName,
                        String email,
                        String phone,
                        CandidateStatus status,
                        String appliedPosition,
                        LocalDate applicationDate,
                        String rejectionReason) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.status = status;
        this.appliedPosition = appliedPosition;
        this.applicationDate = applicationDate;
        this.rejectionReason = rejectionReason;
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public CandidateStatus getStatus() {
        return status;
    }

    public String getAppliedPosition() {
        return appliedPosition;
    }

    public LocalDate getApplicationDate() {
        return applicationDate;
    }

    public String getRejectionReason() {
        return rejectionReason;
    }

    public CandidateDto(Long id, String firstName, String lastName, String email,
                        String phone, CandidateStatus status, String appliedPosition,
                        LocalDate applicationDate, String rejectionReason) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.status = status;
        this.appliedPosition = appliedPosition;
        this.applicationDate = applicationDate;
        this.rejectionReason = rejectionReason;
    }

    public Long getId() { return id; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getEmail() { return email; }
    public String getPhone() { return phone; }
    public CandidateStatus getStatus() { return status; }
    public String getAppliedPosition() { return appliedPosition; }
    public LocalDate getApplicationDate() { return applicationDate; }
    public String getRejectionReason() { return rejectionReason; }
}
