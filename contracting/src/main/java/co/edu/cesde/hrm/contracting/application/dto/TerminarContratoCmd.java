package co.edu.cesde.hrm.contracting.application.dto;

import jakarta.validation.constraints.NotBlank;

public record TerminarContratoCmd(
        @NotBlank(message = "El motivo de terminación es obligatorio")
        String motivoTerminacion
) {
}
