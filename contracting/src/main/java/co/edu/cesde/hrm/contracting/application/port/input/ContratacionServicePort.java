package co.edu.cesde.hrm.contracting.application.port.input;

import co.edu.cesde.hrm.contracting.application.dto.ContratarEmpleadoCmd;
import co.edu.cesde.hrm.contracting.application.dto.EmpleadoDTO;

import java.time.LocalDate;

public interface ContratacionServicePort {
    EmpleadoDTO contratarEmpleado(ContratarEmpleadoCmd cmd);

    void renovarContrato(Long contratoId, LocalDate nuevaFechaFin);

    void terminarContrato(Long contratoId, String motivoTerminacion);
}
