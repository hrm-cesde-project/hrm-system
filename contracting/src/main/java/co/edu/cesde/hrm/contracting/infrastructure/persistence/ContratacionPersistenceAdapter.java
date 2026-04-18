package co.edu.cesde.hrm.contracting.infrastructure.persistence;

import co.edu.cesde.hrm.contracting.application.port.output.ContratacionPersistencePort;
import co.edu.cesde.hrm.contracting.domain.enums.EstadoEmpleado;
import co.edu.cesde.hrm.contracting.domain.model.Contrato;
import co.edu.cesde.hrm.contracting.domain.model.Empleado;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ContratacionPersistenceAdapter implements ContratacionPersistencePort {

    private final EmpleadoJpaRepo empleadoJpaRepo;
    private final ContratoJpaRepo contratoJpaRepo;

    public ContratacionPersistenceAdapter(EmpleadoJpaRepo empleadoJpaRepo, ContratoJpaRepo contratoJpaRepo) {
        this.empleadoJpaRepo = empleadoJpaRepo;
        this.contratoJpaRepo = contratoJpaRepo;
    }

    @Override
    public Empleado saveEmpleado(Empleado empleado) {
        EmpleadoJpaEntity entity = empleado.getId() != null
                ? empleadoJpaRepo.findById(empleado.getId()).orElseGet(EmpleadoJpaEntity::new)
                : new EmpleadoJpaEntity();

        entity.setAspiranteId(empleado.getAspiranteId());
        entity.setNombres(empleado.getNombres());
        entity.setApellidos(empleado.getApellidos());
        entity.setEmail(empleado.getEmail());
        entity.setCargo(empleado.getCargo());
        entity.setDepartamento(empleado.getDepartamento());
        entity.setEstado(empleado.getEstado());
        entity.setFechaIngreso(empleado.getFechaIngreso());

        EmpleadoJpaEntity saved = empleadoJpaRepo.save(entity);
        empleado.setId(saved.getId());
        return empleado;
    }

    @Override
    public Contrato saveContrato(Contrato contrato) {
        ContratoJpaEntity entity = contrato.getId() != null
                ? contratoJpaRepo.findById(contrato.getId()).orElseGet(ContratoJpaEntity::new)
                : new ContratoJpaEntity();

        EmpleadoJpaEntity empleado = empleadoJpaRepo.findById(contrato.getEmpleadoId())
                .orElseThrow(() -> new EntityNotFoundException("No existe el empleado asociado al contrato"));

        entity.setEmpleado(empleado);
        entity.setTipo(contrato.getTipo());
        entity.setSalarioBase(contrato.getSalarioBase());
        entity.setFechaInicio(contrato.getFechaInicio());
        entity.setFechaFin(contrato.getFechaFin());
        entity.setEstado(contrato.getEstado());
        entity.setMotivoTerminacion(contrato.getMotivoTerminacion());

        ContratoJpaEntity saved = contratoJpaRepo.save(entity);
        contrato.setId(saved.getId());
        return contrato;
    }

    @Override
    public boolean existsEmpleadoActivoByAspiranteId(Long aspiranteId) {
        return empleadoJpaRepo.existsByAspiranteIdAndEstadoIn(
                aspiranteId,
                List.of(EstadoEmpleado.ACTIVO, EstadoEmpleado.EN_PERIODO_PRUEBA)
        );
    }

    @Override
    public Optional<Empleado> findEmpleadoById(Long empleadoId) {
        return empleadoJpaRepo.findById(empleadoId).map(this::toDomainEmpleado);
    }

    @Override
    public Optional<Contrato> findContratoById(Long contratoId) {
        return contratoJpaRepo.findById(contratoId).map(this::toDomainContrato);
    }

    private Empleado toDomainEmpleado(EmpleadoJpaEntity entity) {
        return new Empleado(
                entity.getId(),
                entity.getAspiranteId(),
                entity.getNombres(),
                entity.getApellidos(),
                entity.getEmail(),
                entity.getCargo(),
                entity.getDepartamento(),
                entity.getEstado(),
                entity.getFechaIngreso()
        );
    }

    private Contrato toDomainContrato(ContratoJpaEntity entity) {
        return new Contrato(
                entity.getId(),
                entity.getEmpleado().getId(),
                entity.getTipo(),
                entity.getSalarioBase(),
                entity.getFechaInicio(),
                entity.getFechaFin(),
                entity.getEstado(),
                entity.getMotivoTerminacion()
        );
    }
}
