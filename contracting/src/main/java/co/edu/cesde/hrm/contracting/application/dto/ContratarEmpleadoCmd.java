package co.edu.cesde.hrm.contracting.application.dto;

import co.edu.cesde.hrm.contracting.domain.enums.TipoContrato;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDate;

public record ContratarEmpleadoCmd(
        @NotNull(message = "El aspiranteId es obligatorio")
        Long aspiranteId,

        String nombres,

        String apellidos,

        @Email(message = "El email debe ser válido")
        String email,

        @NotBlank(message = "El cargo es obligatorio")
        String cargo,

        @NotBlank(message = "El departamento es obligatorio")
        String departamento,

        @NotNull(message = "El tipo de contrato es obligatorio")
        TipoContrato tipoContrato,

        @NotNull(message = "El salario base es obligatorio")
        @DecimalMin(value = "0.01", message = "El salario base debe ser mayor a cero")
        BigDecimal salarioBase,

        @NotNull(message = "La fecha de inicio es obligatoria")
        LocalDate fechaInicio,

        LocalDate fechaFin
) {
}
