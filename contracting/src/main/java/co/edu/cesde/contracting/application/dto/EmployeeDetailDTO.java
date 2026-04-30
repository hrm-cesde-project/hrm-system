package co.edu.cesde.contracting.application.dto;

import co.edu.cesde.contracting.domain.enums.employedStatus;

import java.util.List;

public record EmployeeDetailDTO(
        Long id,
        String fullName,
        String position,
        String department,
        employedStatus status,
        List<ContractDTO> contractHistory
) {}

record ContractDTO(
        Long id,
        String type,
        java.math.BigDecimal salary,
        java.time.LocalDate startDate,
        String status
) {}