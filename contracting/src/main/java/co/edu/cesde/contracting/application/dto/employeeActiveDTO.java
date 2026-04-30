package co.edu.cesde.contracting.application.dto;

import java.math.BigDecimal;

public record employeeActiveDTO (
        Long employeeId,
        String fullName,
        String position,
        String department,
        BigDecimal salaryBase
){}
