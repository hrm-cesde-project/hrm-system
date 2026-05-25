package co.edu.cesde.hrm.shared.port;

import co.edu.cesde.hrm.shared.dto.EmpleadoActivoDTO;

// ── Puerto hacia E7 — Evaluación ─────────────────────────────
public interface EvaluacionNotifPort {
    /**
     * Notifica a Evaluación que hay un nuevo empleado activo.
     * E7 puede preparar el ciclo de evaluación del periodo en curso.
     *
     * IMPLEMENTADO POR: performance (E7)
     * LLAMADO POR:      contracting (E4) al crear un empleado
     */
    void notificarEmpleadoActivo(EmpleadoActivoDTO empleado);
}
