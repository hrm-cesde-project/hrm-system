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
    public Candidate(String firstName, String lastName, String email,
                     String phone, String appliedPosition, LocalDate applicationDate) {

        if (firstName == null || firstName.isBlank()) {
            throw new IllegalArgumentException("First name is required");
        }
        if (lastName == null || lastName.isBlank()) {
            throw new IllegalArgumentException("Last name is required");
        }
        if (email == null || email.isBlank()) {
            throw new IllegalArgumentException("Email is required");
        }
        if (appliedPosition == null || appliedPosition.isBlank()) {
            throw new IllegalArgumentException("Applied position is required");
        }

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
    // =============================
    // BUSINESS LOGIC
    // =============================

    public void advanceStatus() {
        if (this.status == CandidateStatus.APPLIED) {
            this.status = CandidateStatus.SCREENING;
        } else if (this.status == CandidateStatus.SCREENING) {
            this.status = CandidateStatus.INTERVIEW;
        } else {
            throw new IllegalStateException("Cannot advance from status: " + this.status);
        }
    }

    public void reject(String reason) {
        if (this.status == CandidateStatus.REJECTED) {
            throw new IllegalStateException("Candidate is already rejected");
        }
        if (reason == null || reason.isBlank()) {
            throw new IllegalArgumentException("Rejection reason is required");
        }
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
    public boolean isActive() {
        return this.status != CandidateStatus.REJECTED;
    }

    // =============================
    // GETTERS & SETTERS
    // =============================

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getEmail() { return email; }
    public String getPhone() { return phone; }
    public CandidateStatus getStatus() { return status; }
    public String getAppliedPosition() { return appliedPosition; }
    public LocalDate getApplicationDate() { return applicationDate; }
    public String getRejectionReason() { return rejectionReason; }
}