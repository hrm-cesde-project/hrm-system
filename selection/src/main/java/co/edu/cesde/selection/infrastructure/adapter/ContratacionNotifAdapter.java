package co.edu.cesde.selection.infrastructure.adapter;

import co.edu.cesde.selection.application.port.output.ContratacionNotifPort;
import org.springframework.stereotype.Component;

@Component
public abstract class ContratacionNotifAdapter implements ContratacionNotifPort {

    @Override
    public void notificarContratacion(Long procesoId) {
        System.out.println("Notificando contratación: " + procesoId);
    }
}