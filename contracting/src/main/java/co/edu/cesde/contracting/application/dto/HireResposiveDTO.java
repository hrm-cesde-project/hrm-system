package co.edu.cesde.contracting.application.dto;

import co.edu.cesde.contracting.domain.enums.contractStatus;
import co.edu.cesde.contracting.domain.enums.employedStatus;

public record HireResposiveDTO() {
    public record HireResponseDTO(
            Long employeeId,
            Long contractId,
            employedStatus employeeStatus,
            contractStatus contractStatus
    ) {}
}
