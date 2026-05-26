package co.edu.cesde.selection.application.usecase;

import co.edu.cesde.selection.application.dto.EntrevistaCmd;
import co.edu.cesde.selection.application.dto.ProcesoDTO;
import co.edu.cesde.selection.application.port.input.SeleccionServicePort;
import co.edu.cesde.selection.application.port.output.ContratacionNotifPort;
import co.edu.cesde.selection.application.port.output.SelecionPersistencePort;
import co.edu.cesde.hrm.shared.dto.AspirantePreseleccionadoDTO;
import co.edu.cesde.selection.domain.ProcesoSeleccion; // <-- Importamos la clase de Dominio

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
        return null;
    }

    @Override
    public void registrarEntrevista(EntrevistaCmd cmd) {
    }

    @Override
    public void aprobar(Long procesoId) {
        // Lógica de la HU-E2-04:

        // 1. Creamos el objeto (Más adelante lo buscarás en la BD usando persistencePort)
        ProcesoSeleccion proceso = new ProcesoSeleccion();

        // 2. Llamamos al puerto usando el nombre exacto que definimos en la interfaz
        notifPort.notificarCandidatoAprobado(proceso);
    }

    @Override
    public void rechazar(Long procesoId, String motivo) {
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