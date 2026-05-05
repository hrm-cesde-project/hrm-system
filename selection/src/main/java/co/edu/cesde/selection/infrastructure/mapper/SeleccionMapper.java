package co.edu.cesde.selection.infrastructure.mapper;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SeleccionMapper {

    // toEntity(domain)  → ProcesoSeleccionJpaEntity
    // toDomain(entity)  → ProcesoSeleccion
    // toDTO(domain)     → ProcesoDTO
    // toCSVRow(proceso) → String[]
}