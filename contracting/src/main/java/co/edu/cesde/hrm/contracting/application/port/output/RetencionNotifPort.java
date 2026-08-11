package co.edu.cesde.hrm.contracting.application.port.output;

import co.edu.cesde.hrm.contracting.application.dto.EmpleadoActivoDTO;


public interface RetencionNotifPort {
    void notificar(EmpleadoActivoDTO dto);
}
