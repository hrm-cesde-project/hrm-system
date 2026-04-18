package co.edu.cesde.hrm.contracting.application.dto;

import co.edu.cesde.hrm.contracting.domain.enums.EstadoEmpleado;

import java.time.LocalDate;

public record EmpleadoDTO(
        Long empleadoId,
        Long aspiranteId,
        String nombres,
        String apellidos,
        String email,
        String cargo,
        String departamento,
        EstadoEmpleado estadoEmpleado,
        LocalDate fechaIngreso,
        ContratoDTO contrato
) {
}
