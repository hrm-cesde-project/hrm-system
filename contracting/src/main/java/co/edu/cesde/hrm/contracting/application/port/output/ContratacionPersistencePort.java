package co.edu.cesde.hrm.contracting.application.port.output;

import co.edu.cesde.hrm.contracting.domain.model.Contrato;
import co.edu.cesde.hrm.contracting.domain.model.Empleado;

public interface ContratacionPersistencePort {

    Empleado saveEmpleado(Empleado empleado);

    Contrato saveContrato(Contrato contrato);

    boolean existsEmpleadoActivoByAspiranteId(Long aspiranteId);
}
