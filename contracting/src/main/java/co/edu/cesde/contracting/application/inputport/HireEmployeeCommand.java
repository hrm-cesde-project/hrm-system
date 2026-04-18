package co.edu.cesde.contracting.application.inputport;
import co.edu.cesde.contracting.domain.enums.contractType;
import java.math.BigDecimal;
import java.time.LocalDate;

public record HireEmployeeCommand(
        Long applicantId,
        String firstName,
        String lastName,
        String email,
        String position,
        String department,
        contractType contractType,
        BigDecimal salaryBase,
        LocalDate startDate
) {}
