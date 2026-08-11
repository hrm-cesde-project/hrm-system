package co.edu.cesde.hrm.contracting.infrastructure.rest;

import co.edu.cesde.hrm.contracting.application.usecase.ContratacionUseCase;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/contratos")
public class ContratacionController {

    private final ContratacionUseCase useCase;

    public ContratacionController(ContratacionUseCase useCase) {
        this.useCase = useCase;
    }

    @PostMapping("/contratar")
    public String contratar() {
        useCase.contratarEmpleado();
        return "Empleado contratado";
    }

    @GetMapping("/empleados/{id}/notificaciones")
    public Map<String, String> estado() {

        Map<String, String> estado = new HashMap<>();
        estado.put("nomina", "ENVIADO");
        estado.put("formacion", "ENVIADO");
        estado.put("retencion", "ENVIADO");
        estado.put("evaluacion", "ENVIADO");

        return estado;
    }
}