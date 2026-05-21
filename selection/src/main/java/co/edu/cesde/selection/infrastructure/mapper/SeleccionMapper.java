package co.edu.cesde.selection.infrastructure.mapper;

import co.edu.cesde.selection.domain.ProcesoSeleccion;
import co.edu.cesde.selection.infrastructure.persistence.ProcesoSeleccionJpaEntity;
import co.edu.cesde.selection.application.dto.ProcesoDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SeleccionMapper {

    ProcesoSeleccionJpaEntity toEntity(ProcesoSeleccion domain);

    ProcesoSeleccion toDomain(ProcesoSeleccionJpaEntity entity);

    ProcesoDTO toDTO(ProcesoSeleccion domain);

    // toCSVRow(proceso) → String[]
    // Se implementará cuando ProcesoDTO tenga sus campos definidos
}