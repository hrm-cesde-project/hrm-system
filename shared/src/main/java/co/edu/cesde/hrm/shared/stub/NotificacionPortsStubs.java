package co.edu.cesde.hrm.shared.stub;

import co.edu.cesde.hrm.shared.dto.EmpleadoActivoDTO;
import co.edu.cesde.hrm.shared.port.NotificacionPorts.*;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

/**
 * STUBS de los 4 puertos de notificación de E4.
 *
 * Cuando E4 contrata un empleado, llama a estos 4 puertos.
 * En semanas 1–3 todos son stubs que solo imprimen un log.
 * En semana 4 cada equipo entrega su implementación real:
 *   - E5 implementa NominaNotifPort
 *   - E3 implementa FormacionNotifPort
 *   - E6 implementa RetencionNotifPort
 *   - E7 implementa EvaluacionNotifPort
 */

// ── Stub para E5 — Nómina ─────────────────────────────────────────
@Component
@ConditionalOnProperty(name = "hrm.stubs.enabled", havingValue = "true", matchIfMissing = true)
class NominaNotifPortStub implements NominaNotifPort {
    @Override
    public void notificarNuevoEmpleado(EmpleadoActivoDTO empleado) {
        System.out.println("[STUB] NominaNotifPort — nuevo empleado: "
                + empleado.getNombreResumen()
                + " | salarioBase=" + empleado.salarioBase());
    }
}

// ── Stub para E3 — Formación ──────────────────────────────────────
@Component
@ConditionalOnProperty(name = "hrm.stubs.enabled", havingValue = "true", matchIfMissing = true)
class FormacionNotifPortStub implements FormacionNotifPort {
    @Override
    public void notificarEmpleadoActivo(EmpleadoActivoDTO empleado) {
        System.out.println("[STUB] FormacionNotifPort — empleado activo: "
                + empleado.getNombreResumen());
    }
}

// ── Stub para E6 — Retención ──────────────────────────────────────
@Component
@ConditionalOnProperty(name = "hrm.stubs.enabled", havingValue = "true", matchIfMissing = true)
class RetencionNotifPortStub implements RetencionNotifPort {
    @Override
    public void notificarEmpleadoActivo(EmpleadoActivoDTO empleado) {
        System.out.println("[STUB] RetencionNotifPort — empleado activo: "
                + empleado.getNombreResumen());
    }
}

// ── Stub para E7 — Evaluación ─────────────────────────────────────
@Component
@ConditionalOnProperty(name = "hrm.stubs.enabled", havingValue = "true", matchIfMissing = true)
class EvaluacionNotifPortStub implements EvaluacionNotifPort {
    @Override
    public void notificarEmpleadoActivo(EmpleadoActivoDTO empleado) {
        System.out.println("[STUB] EvaluacionNotifPort — empleado activo: "
                + empleado.getNombreResumen());
    }
}
