package co.edu.cesde.selection.infrastructure.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface SeleccionJpaRepo extends JpaRepository<ProcesoSeleccionJpaEntity, Long> {
    // Hereda todos los métodos como save(), findById(), etc.
}

