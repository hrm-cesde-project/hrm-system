package co.edu.cesde.hrm.contracting.application.usecase;

import co.edu.cesde.hrm.contracting.application.dto.ContratarEmpleadoCmd;
import co.edu.cesde.hrm.contracting.application.dto.ContratoDTO;
import co.edu.cesde.hrm.contracting.application.dto.EmpleadoDTO;
import co.edu.cesde.hrm.contracting.application.exception.ConflictException;
import co.edu.cesde.hrm.contracting.application.exception.NotFoundException;
import co.edu.cesde.hrm.contracting.application.port.input.ContratacionServicePort;
import co.edu.cesde.hrm.contracting.application.port.output.ContratacionPersistencePort;
import co.edu.cesde.hrm.contracting.domain.enums.EstadoContrato;
import co.edu.cesde.hrm.contracting.domain.model.Contrato;
import co.edu.cesde.hrm.contracting.domain.model.Empleado;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

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

        return construirEmpleadoDTO(empleadoGuardado, contratoGuardado);
    }

    @Override
    public void renovarContrato(Long contratoId, LocalDate nuevaFechaFin) {
        Contrato contratoActual = persistencePort.findContratoById(contratoId)
                .orElseThrow(() -> new NotFoundException("No existe el contrato solicitado"));

        contratoActual.marcarComoVencidoSiAplica(LocalDate.now());
        if (contratoActual.getEstado() != EstadoContrato.VIGENTE) {
            persistencePort.saveContrato(contratoActual);
        }
        contratoActual.validarRenovable(LocalDate.now());
        contratoActual.renovar(nuevaFechaFin);
        persistencePort.saveContrato(contratoActual);

        Contrato nuevoContrato = contratoActual.crearRenovacion(nuevaFechaFin);
        persistencePort.saveContrato(nuevoContrato);
    }

    @Override
    public void terminarContrato(Long contratoId, String motivoTerminacion) {
        Contrato contrato = persistencePort.findContratoById(contratoId)
                .orElseThrow(() -> new NotFoundException("No existe el contrato solicitado"));

        Empleado empleado = persistencePort.findEmpleadoById(contrato.getEmpleadoId())
                .orElseThrow(() -> new NotFoundException("No existe el empleado asociado al contrato"));

        contrato.terminar(motivoTerminacion);
        empleado.retirar(motivoTerminacion);

        persistencePort.saveContrato(contrato);
        persistencePort.saveEmpleado(empleado);
    }

    private EmpleadoDTO construirEmpleadoDTO(Empleado empleado, Contrato contrato) {
        return new EmpleadoDTO(
                empleado.getId(),
                empleado.getAspiranteId(),
                empleado.getNombres(),
                empleado.getApellidos(),
                empleado.getEmail(),
                empleado.getCargo(),
                empleado.getDepartamento(),
                empleado.getEstado(),
                empleado.getFechaIngreso(),
                new ContratoDTO(
                        contrato.getId(),
                        contrato.getTipo(),
                        contrato.getSalarioBase(),
                        contrato.getFechaInicio(),
                        contrato.getFechaFin(),
                        contrato.getEstado()
                )
        );
    }
}
