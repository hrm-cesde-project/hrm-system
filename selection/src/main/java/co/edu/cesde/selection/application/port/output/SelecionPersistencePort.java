package co.edu.cesde.selection.application.port.output;

import co.edu.cesde.selection.domain.ProcesoSeleccion;

import java.util.List;
import java.util.Optional;

public interface SelecionPersistencePort {

    ProcesoSeleccion save(ProcesoSeleccion proceso);
    Optional<ProcesoSeleccion> findById(Long id);
    List<ProcesoSeleccion> findByEstado(String estado);
    Optional<ProcesoSeleccion> findByAspiranteId(Long idAspirante);
    List<ProcesoSeleccion> findAll();

}
