package co.edu.cesde.contracting.domain.model;

import co.edu.cesde.contracting.application.dto.employeeActiveDTO;
import co.edu.cesde.contracting.domain.enums.employedStatus;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
@Getter
@Setter
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

    public void active() {
        this.status = employedStatus.ACTIVE;
    }

    public boolean isActive() {
        return this.status == employedStatus.ACTIVE || this.status == employedStatus.ON_PROBATION;
    }

    public employeeActiveDTO toemployeeActiveDTO() {
        BigDecimal salary = contracts.stream()
                .filter(Contract::isCurrent)
                .map(Contract::getSalary)
                .findFirst()
                .orElse(BigDecimal.ZERO);

        return new employeeActiveDTO(
                this.id,
                this.firstName + " " + this.lastName,
                this.position,
                this.department,
                salary
        );
    }

}
