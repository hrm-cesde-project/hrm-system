package co.edu.cesde.hrm.contracting.application.dto;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record RenovarContratoCmd(
        @NotNull(message = "La nueva fecha de fin es obligatoria")
        LocalDate nuevaFechaFin
) {
}
