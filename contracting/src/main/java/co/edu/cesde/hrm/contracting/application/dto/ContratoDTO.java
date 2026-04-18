package co.edu.cesde.hrm.contracting.application.dto;

import co.edu.cesde.hrm.contracting.domain.enums.EstadoContrato;
import co.edu.cesde.hrm.contracting.domain.enums.TipoContrato;

import java.math.BigDecimal;
import java.time.LocalDate;

public record ContratoDTO(
        Long contratoId,
        TipoContrato tipoContrato,
        BigDecimal salarioBase,
        LocalDate fechaInicio,
        LocalDate fechaFin,
        EstadoContrato estadoContrato
) {
}
