package co.edu.cesde.selection.application.port.output;

import co.edu.cesde.selection.domain.ProcesoSeleccion;

public interface ContratacionNotifPort {
    // Este nombre y este parámetro (ProcesoSeleccion) son la clave para que todo conecte
    void notificarCandidatoAprobado(ProcesoSeleccion proceso);
}