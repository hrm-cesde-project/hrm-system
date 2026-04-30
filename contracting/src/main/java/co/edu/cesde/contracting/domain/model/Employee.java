package co.edu.cesde.contracting.domain.model;

import co.edu.cesde.contracting.application.dto.employeeActiveDTO;
import co.edu.cesde.contracting.domain.enums.employedStatus;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class Employee {
    private Long id;
    private Long applicantId;
    private String firstName;
    private String lastName;
    private String email;
    private String position;
    private String department;
    private employedStatus status;
    private LocalDate startDate;

    private List<Contract> contracts;

    public void active(){
        this.status = employedStatus.ACTIVE;
    }
    public boolean isActive(){
        return this.status == employedStatus.ACTIVE || this.status == employedStatus.ON_PROBATION;
    }
    public employeeActiveDTO toemployeeActiveDTO(){
        BigDecimal salary = contracts.stream()
                .filter(Contract::isCurrent)
                .map(Contract::getSalary)
                .findFirst()
                .orElse(BigDecimal.ZERO);

        return new employeeActiveDTO(
                this.id,
                this.firstName +" "+ this.lastName,
                this.position,
                this.department,
                salary
        );
    }

    public Long getId() {
        return id;
    }

    public Long getApplicantId() {
        return applicantId;
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

    public String getPosition() {
        return position;
    }

    public String getDepartment() {
        return department;
    }

    public employedStatus getStatus() {
        return status;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public List<Contract> getContracts() {
        return contracts;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setApplicantId(Long applicantId) {
        this.applicantId = applicantId;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setStatus(employedStatus status) {
        this.status = status;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public void setContracts(List<Contract> contracts) {
        this.contracts = contracts;
    }
}
