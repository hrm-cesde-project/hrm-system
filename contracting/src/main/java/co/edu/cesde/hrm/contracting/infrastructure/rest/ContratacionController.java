package co.edu.cesde.hrm.contracting.infrastructure.rest;

import co.edu.cesde.hrm.contracting.application.dto.ContratarEmpleadoCmd;
import co.edu.cesde.hrm.contracting.application.dto.EmpleadoDTO;
import co.edu.cesde.hrm.contracting.application.dto.RenovarContratoCmd;
import co.edu.cesde.hrm.contracting.application.dto.TerminarContratoCmd;
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

    @PutMapping("/{id}/renovar")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void renovarContrato(@PathVariable Long id, @Valid @RequestBody RenovarContratoCmd cmd) {
        contratacionServicePort.renovarContrato(id, cmd.nuevaFechaFin());
    }

    @PutMapping("/{id}/terminar")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void terminarContrato(@PathVariable Long id, @Valid @RequestBody TerminarContratoCmd cmd) {
        contratacionServicePort.terminarContrato(id, cmd.motivoTerminacion());
    }
}
