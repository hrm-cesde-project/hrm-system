package co.edu.cesde.hrm.shared.port;

import co.edu.cesde.hrm.shared.dto.EmpleadoActivoDTO;

// ── Puerto hacia E6 — Retención/SST ──────────────────────────
public interface RetencionNotifPort {
    /**
     * Notifica a Retención que hay un nuevo empleado activo.
     * E6 puede crear su ficha SST inicial.
     *
     * IMPLEMENTADO POR: retention (E6)
     * LLAMADO POR:      contracting (E4) al crear un empleado
     */
    void notificarEmpleadoActivo(EmpleadoActivoDTO empleado);
}
