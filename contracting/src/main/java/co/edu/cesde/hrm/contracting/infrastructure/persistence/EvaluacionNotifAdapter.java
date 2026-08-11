package co.edu.cesde.hrm.contracting.infrastructure.persistence;

import co.edu.cesde.hrm.contracting.application.dto.EmpleadoActivoDTO;
import co.edu.cesde.hrm.contracting.application.port.output.EvaluacionNotifPort;

public class EvaluacionNotifAdapter implements EvaluacionNotifPort {
    @Override
    public void notificar(EmpleadoActivoDTO dto) {
        System.out.println("Notificando a nomina: " + dto.id);
    }
}
