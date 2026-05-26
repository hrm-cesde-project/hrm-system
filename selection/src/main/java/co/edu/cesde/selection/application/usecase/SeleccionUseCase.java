package co.edu.cesde.selection.application.usecase;

import co.edu.cesde.selection.application.dto.EntrevistaCmd;
import co.edu.cesde.selection.application.dto.ProcesoDTO;
import co.edu.cesde.selection.application.port.input.SeleccionServicePort;
import co.edu.cesde.selection.application.port.output.ContratacionNotifPort;
import co.edu.cesde.selection.application.port.output.SelecionPersistencePort;
// NOTA: Aquí tu compañero debe importar el DTO de la carpeta shared del Equipo 1
import co.edu.cesde.hrm.shared.dto.AspirantePreseleccionadoDTO;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service

public class SeleccionUseCase implements SeleccionServicePort {



    private final SelecionPersistencePort persistencePort;
    private final ContratacionNotifPort notifPort;

    public SeleccionUseCase(SelecionPersistencePort persistencePort, ContratacionNotifPort notifPort) {
        this.persistencePort = persistencePort;
        this.notifPort = notifPort;
    }

    @Override
    public ProcesoDTO iniciarProceso(AspirantePreseleccionadoDTO dto) {
        // Lógica de la HU-E2-01:
        // 1. Validar que no tenga un proceso activo (usando persistencePort)
        // 2. Crear el objeto de Dominio (ProcesoSeleccion) con los datos del dto
        // 3. Guardarlo en la base de datos
        // 4. Retornar el ProcesoDTO
        return null;
    }

    @Override
    public void registrarEntrevista(EntrevistaCmd cmd) {
        // Lógica de la HU-E2-02
    }

    @Override
    public void aprobar(Long procesoId) {
        // Lógica de la HU-E2-04: Al aprobar, llamamos al puerto de salida:
        // notifPort.notificarAprobado(aspiranteId, cargo);
    }

    @Override
    public void rechazar(Long procesoId, String motivo) {
        // Lógica de la HU-E2-04
    }

    @Override
    public ProcesoDTO buscarPorId(Long id) {
        return null;
    }

    @Override
    public List<ProcesoDTO> listarAprobados() {
        return null;
    }

    @Override
    public byte[] exportarCSV() {
        return null;
    }
}