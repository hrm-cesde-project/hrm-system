package co.edu.cesde.hrm.shared.port;

import co.edu.cesde.hrm.shared.dto.EmpleadoActivoDTO;

/**
 * Agrupa los puertos de notificación de E4 hacia los módulos dependientes.
 */
public final class NotificacionPorts {

    private NotificacionPorts() {
    }

    public interface NominaNotifPort {
        void notificarNuevoEmpleado(EmpleadoActivoDTO empleado);
    }

    public interface FormacionNotifPort {
        void notificarEmpleadoActivo(EmpleadoActivoDTO empleado);
    }

    public interface RetencionNotifPort {
        void notificarEmpleadoActivo(EmpleadoActivoDTO empleado);
    }

    public interface EvaluacionNotifPort {
        void notificarEmpleadoActivo(EmpleadoActivoDTO empleado);
    }
}
