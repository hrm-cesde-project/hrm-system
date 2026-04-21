package co.edu.cesde.training.infrastructure.rest;

import co.edu.cesde.training.application.inputport.TrainingServicePort;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/training")
public class TrainingController {

    private final TrainingServicePort service;

    public TrainingController(TrainingServicePort service) {
        this.service = service;
    }

    @PostMapping("/programs")
    public void createProgram() {}

    @GetMapping("/programs")
    public void listPrograms() {}

    @GetMapping("/programs/active")
    public void listActivePrograms() {}

    @PostMapping("/enrollments")
    public void enroll() {}

    @PutMapping("/enrollments/{id}/progress")
    public void registerProgress() {}

    @PutMapping("/enrollments/{id}/complete")
    public void complete() {}

    @GetMapping("/employee/{employeeId}")
    public void employeeHistory() {}

    @GetMapping("/export/csv")
    public void exportCSV() {}
}