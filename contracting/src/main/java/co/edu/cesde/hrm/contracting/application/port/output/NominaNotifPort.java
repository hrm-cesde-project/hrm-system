package co.edu.cesde.hrm.contracting.application.port.output;

import co.edu.cesde.hrm.contracting.application.dto.EmpleadoActivoDTO;


public interface NominaNotifPort {
    void notificar(EmpleadoActivoDTO dto);
}
