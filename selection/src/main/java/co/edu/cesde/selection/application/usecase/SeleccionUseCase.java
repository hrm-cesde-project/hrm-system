package co.edu.cesde.selection.application.usecase;

import co.edu.cesde.selection.application.dto.EntrevistaCmd;
import co.edu.cesde.selection.application.dto.ProcesoDTO;
import co.edu.cesde.selection.application.port.input.SeleccionServicePort;
import co.edu.cesde.selection.application.port.output.ContratacionNotifPort;
import co.edu.cesde.selection.application.port.output.SeleccionPersistencePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SeleccionUseCase implements SeleccionServicePort {

    private final SeleccionPersistencePort persistencePort;
    private final ContratacionNotifPort notifPort;

    @Override
    public ProcesoDTO iniciarProceso(ProcesoDTO procesoDTO) {
        return procesoDTO; // luego se implementa lógica real
    }

    @Override
    public void registrarEntrevista(EntrevistaCmd cmd) {
        // lógica después
    }

    @Override
    public void finalizarProceso(Long procesoId) {
        notifPort.notificarContratacion(procesoId);
    }
}