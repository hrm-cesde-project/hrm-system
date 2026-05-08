package co.edu.cesde.selection.infrastructure.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/seleccion")
public class SeleccionController {

    @PostMapping
    public ResponseEntity<?> iniciarProceso(@RequestBody Object dto) {
        return null;
    }

    @PostMapping("/{id}/entrevistas")
    public ResponseEntity<?> registrarEntrevista(@PathVariable Long id, @RequestBody Object cmd) {
        return null;
    }

    @GetMapping("/{id}/entrevistas")
    public ResponseEntity<?> listarEntrevistas(@PathVariable Long id) {
        return null;
    }

    @GetMapping
    public ResponseEntity<?> listar(@RequestParam(required = false) String estado) {
        return null;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable Long id) {
        return null;
    }

    @PutMapping("/{id}/aprobar")
    public ResponseEntity<?> aprobar(@PathVariable Long id) {
        return null;
    }

    @PutMapping("/{id}/rechazar")
    public ResponseEntity<?> rechazar(@PathVariable Long id, @RequestBody Object motivo) {
        return null;
    }

    @GetMapping("/aprobados")
    public ResponseEntity<?> listarAprobados() {
        return null;
    }

    @GetMapping("/export/csv")
    public ResponseEntity<?> exportarCSV(@RequestParam(required = false) String estado) {
        return null;
    }
}