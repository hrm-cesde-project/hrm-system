package co.edu.cesde.recruitment.domain.model;

import co.edu.cesde.recruitment.domain.enums.CandidateStatus;

import java.time.LocalDate;

public class Candidate {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private CandidateStatus status;
    private String appliedPosition;
    private LocalDate applicationDate;
    private String rejectionReason;

    public Candidate(Long id,
                     String firstName,
                     String lastName,
                     String email,
                     String phone,
                     CandidateStatus status) {

        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.status = status;
    }

    public Candidate(String firstName,
                     String lastName,
                     String email,
                     String phone,
                     String appliedPosition,
                     LocalDate applicationDate) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.appliedPosition = appliedPosition;
        this.applicationDate = applicationDate;
        this.status = CandidateStatus.APPLIED;
    }

    public void advanceStatus() {
        if (status == CandidateStatus.APPLIED) {
            status = CandidateStatus.INTERVIEW;
        } else if (status == CandidateStatus.INTERVIEW) {
            status = CandidateStatus.HIRED;
        }
    }

    public void reject(String reason) {
        this.status = CandidateStatus.REJECTED;
        this.rejectionReason = reason;
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

    public void setId(Long id) {
        this.id = id;
    }
}