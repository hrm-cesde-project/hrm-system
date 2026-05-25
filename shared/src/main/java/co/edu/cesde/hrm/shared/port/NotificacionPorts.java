package co.edu.cesde.hrm.shared.port;

import co.edu.cesde.hrm.shared.dto.EmpleadoActivoDTO;

/**
 * ═══════════════════════════════════════════════════════════════
 *  PUERTOS DE NOTIFICACIÓN — E4 → otros módulos
 *
 *  Cuando E4 (Contratación) contrata un nuevo empleado, llama
 *  secuencialmente a estos 4 puertos para notificar a los demás
 *  módulos que hay un empleado nuevo listo para operar.
 *
 *  PATRÓN: fire-and-forget con logging de errores.
 *  Si una notificación falla, se loguea pero NO se revierte la contratación.
 *
 *  SEMANAS 1–3: todos usan stubs (solo loguean el evento)
 *  SEMANA 4:    cada equipo entrega su implementación real
 * ═══════════════════════════════════════════════════════════════
 */

// ── Puerto hacia E5 — Nómina ──────────────────────────────────
interface NominaNotifPort {
    /**
     * Notifica a Nómina que hay un nuevo empleado disponible para liquidación.
     * E5 puede registrar al empleado en su sistema con el salarioBase del contrato.
     *
     * IMPLEMENTADO POR: payroll (E5)
     * LLAMADO POR:      contracting (E4) al crear un empleado
     */
    void notificarNuevoEmpleado(EmpleadoActivoDTO empleado);
}

// ── Puerto hacia E3 — Formación ───────────────────────────────
interface FormacionNotifPort {
    /**
     * Notifica a Formación que hay un nuevo empleado activo.
     * E3 puede inscribirlo automáticamente al programa de Inducción si existe.
     *
     * IMPLEMENTADO POR: training (E3)
     * LLAMADO POR:      contracting (E4) al crear un empleado
     */
    void notificarEmpleadoActivo(EmpleadoActivoDTO empleado);
}

// ── Puerto hacia E6 — Retención/SST ──────────────────────────
interface RetencionNotifPort {
    /**
     * Notifica a Retención que hay un nuevo empleado activo.
     * E6 puede crear su ficha SST inicial.
     *
     * IMPLEMENTADO POR: retention (E6)
     * LLAMADO POR:      contracting (E4) al crear un empleado
     */
    void notificarEmpleadoActivo(EmpleadoActivoDTO empleado);
}

// ── Puerto hacia E7 — Evaluación ─────────────────────────────
interface EvaluacionNotifPort {
    /**
     * Notifica a Evaluación que hay un nuevo empleado activo.
     * E7 puede preparar el ciclo de evaluación del periodo en curso.
     *
     * IMPLEMENTADO POR: performance (E7)
     * LLAMADO POR:      contracting (E4) al crear un empleado
     */
    void notificarEmpleadoActivo(EmpleadoActivoDTO empleado);
}
