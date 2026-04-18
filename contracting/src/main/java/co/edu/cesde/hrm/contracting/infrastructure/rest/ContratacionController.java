package co.edu.cesde.hrm.contracting.infrastructure.rest;

import co.edu.cesde.hrm.contracting.application.dto.ContratarEmpleadoCmd;
import co.edu.cesde.hrm.contracting.application.dto.EmpleadoDTO;
import co.edu.cesde.hrm.contracting.application.port.input.ContratacionServicePort;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/contratos")
public class ContratacionController {

    private final ContratacionServicePort contratacionServicePort;

    public ContratacionController(ContratacionServicePort contratacionServicePort) {
        this.contratacionServicePort = contratacionServicePort;
    }

    @PostMapping("/empleados")
    @ResponseStatus(HttpStatus.CREATED)
    public EmpleadoDTO contratarEmpleado(@Valid @RequestBody ContratarEmpleadoCmd cmd) {
        return contratacionServicePort.contratarEmpleado(cmd);
    }
}
