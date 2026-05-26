package co.edu.cesde.selection.infrastructure.mapper;

import co.edu.cesde.selection.application.dto.ProcesoDTO;
import co.edu.cesde.selection.domain.ProcesoSeleccion;
import co.edu.cesde.selection.infrastructure.persistence.ProcesoSeleccionJpaEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface SeleccionMapper {

    ProcesoSeleccionJpaEntity toEntity(ProcesoSeleccion domain);

    ProcesoSeleccion toDomain(ProcesoSeleccionJpaEntity entity);

    @Mapping(target = "estado", expression = "java(domain.getEstado().name())")
    ProcesoDTO toDTO(ProcesoSeleccion domain);
}