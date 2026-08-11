package co.edu.cesde.hrm.contracting.application.port.output;

import co.edu.cesde.hrm.contracting.application.dto.EmpleadoActivoDTO;

public interface EvaluacionNotifPort {
    void notificar(EmpleadoActivoDTO dto);
}
