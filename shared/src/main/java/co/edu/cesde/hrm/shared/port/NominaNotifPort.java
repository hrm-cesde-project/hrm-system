package co.edu.cesde.hrm.shared.port;

import co.edu.cesde.hrm.shared.dto.EmpleadoActivoDTO;

// ── Puerto hacia E5 — Nómina ──────────────────────────────────
public interface NominaNotifPort {
    /**
     * Notifica a Nómina que hay un nuevo empleado disponible para liquidación.
     * E5 puede registrar al empleado en su sistema con el salarioBase del contrato.
     *
     * IMPLEMENTADO POR: payroll (E5)
     * LLAMADO POR:      contracting (E4) al crear un empleado
     */
    void notificarNuevoEmpleado(EmpleadoActivoDTO empleado);
}
