package co.edu.cesde.selection.application.port.input;

import co.edu.cesde.hrm.shared.dto.AspirantePreseleccionadoDTO;
import co.edu.cesde.selection.application.dto.ProcesoDTO;
import co.edu.cesde.selection.application.dto.EntrevistaCmd;
import java.util.List;

public interface SeleccionServicePort {

    // HU-E2-01: Iniciar proceso usando el DTO compartido con el módulo E1
    ProcesoDTO iniciarProceso(AspirantePreseleccionadoDTO dto);

    // HU-E2-02: Registrar una nueva entrevista para un aspirante
    void registrarEntrevista(EntrevistaCmd cmd);

    // HU-E2-04: Aprobar un proceso de selección
    void aprobar(Long procesoId);

    // HU-E2-04: Rechazar un proceso de selección con su respectivo motivo
    void rechazar(Long procesoId, String motivo);

    // HU-E2-03: Consultar el estado detallado de un proceso por su ID
    ProcesoDTO buscarPorId(Long id);

    // HU-E2-06: Listar todos los procesos aprobados para el módulo de contratación
    List<ProcesoDTO> listarAprobados();

    // HU-E2-05: Exportar los reportes de selección en formato binario CSV
    byte[] exportarCSV();
}