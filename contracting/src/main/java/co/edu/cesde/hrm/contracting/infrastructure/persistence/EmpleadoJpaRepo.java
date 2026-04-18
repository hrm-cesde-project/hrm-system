package co.edu.cesde.hrm.contracting.infrastructure.persistence;

import co.edu.cesde.hrm.contracting.domain.enums.EstadoEmpleado;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface EmpleadoJpaRepo extends JpaRepository<EmpleadoJpaEntity, Long> {
    boolean existsByAspiranteIdAndEstadoIn(Long aspiranteId, Collection<EstadoEmpleado> estados);
}
