package co.edu.cesde.hrm.shared.port;

import co.edu.cesde.hrm.shared.dto.EmpleadoActivoDTO;

// ── Puerto hacia E3 — Formación ───────────────────────────────
public interface FormacionNotifPort {
    /**
     * Notifica a Formación que hay un nuevo empleado activo.
     * E3 puede inscribirlo automáticamente al programa de Inducción si existe.
     *
     * IMPLEMENTADO POR: training (E3)
     * LLAMADO POR:      contracting (E4) al crear un empleado
     */
    void notificarEmpleadoActivo(EmpleadoActivoDTO empleado);
}
