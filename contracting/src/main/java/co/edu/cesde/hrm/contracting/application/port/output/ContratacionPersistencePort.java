package co.edu.cesde.hrm.contracting.application.port.output;

import java.util.List;
import java.util.Map;

public interface ContratacionPersistencePort {

    List<Map<String, String>> obtenerEmpleados(String estadoEmpleado);

}