package co.edu.cesde.hrm.contracting.application.port.input;

import co.edu.cesde.hrm.contracting.application.dto.ContratarEmpleadoCmd;
import co.edu.cesde.hrm.contracting.application.dto.EmpleadoDTO;

public interface ContratacionServicePort {
    EmpleadoDTO contratarEmpleado(ContratarEmpleadoCmd cmd);
}
