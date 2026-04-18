package co.edu.cesde.hrm.contracting.application.usecase;

import co.edu.cesde.hrm.contracting.application.dto.ContratarEmpleadoCmd;
import co.edu.cesde.hrm.contracting.application.dto.ContratoDTO;
import co.edu.cesde.hrm.contracting.application.dto.EmpleadoDTO;
import co.edu.cesde.hrm.contracting.application.exception.ConflictException;
import co.edu.cesde.hrm.contracting.application.port.input.ContratacionServicePort;
import co.edu.cesde.hrm.contracting.application.port.output.ContratacionPersistencePort;
import co.edu.cesde.hrm.contracting.domain.model.Contrato;
import co.edu.cesde.hrm.contracting.domain.model.Empleado;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ContratacionUseCase implements ContratacionServicePort {

    private final ContratacionPersistencePort persistencePort;

    public ContratacionUseCase(ContratacionPersistencePort persistencePort) {
        this.persistencePort = persistencePort;
    }

    @Override
    public EmpleadoDTO contratarEmpleado(ContratarEmpleadoCmd cmd) {
        if (persistencePort.existsEmpleadoActivoByAspiranteId(cmd.aspiranteId())) {
            throw new ConflictException("El aspirante ya tiene un empleado activo asociado");
        }

        Empleado empleado = Empleado.contratar(
                cmd.aspiranteId(),
                cmd.nombres(),
                cmd.apellidos(),
                cmd.email(),
                cmd.cargo(),
                cmd.departamento(),
                cmd.fechaInicio(),
                cmd.tipoContrato()
        );

        Empleado empleadoGuardado = persistencePort.saveEmpleado(empleado);

        Contrato contrato = Contrato.crearInicial(
                cmd.tipoContrato(),
                cmd.salarioBase(),
                cmd.fechaInicio(),
                cmd.fechaFin()
        );
        contrato.setEmpleadoId(empleadoGuardado.getId());

        Contrato contratoGuardado = persistencePort.saveContrato(contrato);

        return new EmpleadoDTO(
                empleadoGuardado.getId(),
                empleadoGuardado.getAspiranteId(),
                empleadoGuardado.getNombres(),
                empleadoGuardado.getApellidos(),
                empleadoGuardado.getEmail(),
                empleadoGuardado.getCargo(),
                empleadoGuardado.getDepartamento(),
                empleadoGuardado.getEstado(),
                empleadoGuardado.getFechaIngreso(),
                new ContratoDTO(
                        contratoGuardado.getId(),
                        contratoGuardado.getTipo(),
                        contratoGuardado.getSalarioBase(),
                        contratoGuardado.getFechaInicio(),
                        contratoGuardado.getFechaFin(),
                        contratoGuardado.getEstado()
                )
        );
    }
}
