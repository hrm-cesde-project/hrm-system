package co.edu.cesde.contracting.infrastructure.controller;

import co.edu.cesde.contracting.application.dto.employeeActiveDTO;

import co.edu.cesde.contracting.application.inputport.EmployeeQueryService;
import co.edu.cesde.contracting.domain.model.Contract;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contratos/empleados")
public class EmployeeQueryController {

    private final EmployeeQueryService queryService;

    public EmployeeQueryController(EmployeeQueryService queryService) {
        this.queryService = queryService;
    }

    @GetMapping
    public ResponseEntity<List<employeeActiveDTO>> getAll() {
        return ResponseEntity.ok(queryService.getAllWithCurrentContract());
    }

    @GetMapping("/activos")
    public ResponseEntity<List<employeeActiveDTO>> getActives() {
        return ResponseEntity.ok(queryService.getActiveEmployees());
    }

    @GetMapping("/{id}/contrato-vigente")
    public ResponseEntity<Contract> getCurrentContract(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(queryService.getCurrentContract(id));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}