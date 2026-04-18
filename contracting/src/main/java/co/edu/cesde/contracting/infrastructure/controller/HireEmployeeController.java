package co.edu.cesde.contracting.infrastructure.controller;


import co.edu.cesde.contracting.application.dto.HireResposiveDTO;
import co.edu.cesde.contracting.application.inputport.HireEmployeeCommand;
import co.edu.cesde.contracting.application.inputport.HireEmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/domain/model")
public class HireEmployeeController {

    private final HireEmployeeService hireService;

    public HireEmployeeController(HireEmployeeService hireService) {
        this.hireService = hireService;
    }

    @PostMapping
    public ResponseEntity<HireResposiveDTO.HireResponseDTO> hire(@RequestBody HireEmployeeCommand command) {
        try {
            HireResposiveDTO.HireResponseDTO response = hireService.execute(command);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } catch (Exception e) {
            // Si el aspirante ya existe, retornar 409 Conflict
            return new ResponseEntity<>(null, HttpStatus.CONFLICT);
        }
    }
}
