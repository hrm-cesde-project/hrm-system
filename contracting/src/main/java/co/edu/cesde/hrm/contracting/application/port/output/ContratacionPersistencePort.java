package co.edu.cesde.hrm.contracting.application.port.output;

import co.edu.cesde.hrm.contracting.domain.model.Contrato;
import co.edu.cesde.hrm.contracting.domain.model.Empleado;

import java.util.Optional;

public interface ContratacionPersistencePort {

    Empleado saveEmpleado(Empleado empleado);

    Contrato saveContrato(Contrato contrato);

    boolean existsEmpleadoActivoByAspiranteId(Long aspiranteId);

    Optional<Empleado> findEmpleadoById(Long empleadoId);

    Optional<Contrato> findContratoById(Long contratoId);
}
