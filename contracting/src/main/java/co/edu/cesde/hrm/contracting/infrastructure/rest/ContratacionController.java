package co.edu.cesde.hrm.contracting.infrastructure.rest;

import co.edu.cesde.hrm.contracting.application.usecase.ContratacionUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/contratos")
public class ContratacionController {

    private final ContratacionUseCase useCase;

    public ContratacionController(ContratacionUseCase useCase) {
        this.useCase = useCase;
    }

    @GetMapping("/empleados/export/csv")
    public ResponseEntity<String> exportarCSV(
            @RequestParam(required = false) String estadoEmpleado) {

        String csv = useCase.exportarCSV(estadoEmpleado);

        return ResponseEntity.ok()
                .header("Content-Type", "text/csv")
                .header("Content-Disposition", "attachment; filename=contratacion.csv")
                .body(csv);
    }
}