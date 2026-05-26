package co.edu.cesde.training.infrastructure.rest;

import co.edu.cesde.training.application.dto.EnrollmentCmd;
import co.edu.cesde.training.application.dto.EnrollmentDTO;
import co.edu.cesde.training.application.dto.ProgramDTO;
import co.edu.cesde.training.application.dto.CertificationDTO;
import co.edu.cesde.training.application.inputport.TrainingServicePort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/training")
public class TrainingController {

    private final TrainingServicePort servicePort;

    public TrainingController(TrainingServicePort servicePort) {
        this.servicePort = servicePort;
    }

    @PostMapping("/programs")
    public ResponseEntity<ProgramDTO> createProgram(
            @RequestBody ProgramDTO dto
    ) {
        return ResponseEntity.ok(
                servicePort.createProgram(dto)
        );
    }

    @GetMapping("/programs")
    public ResponseEntity<List<ProgramDTO>> getPrograms() {
        return ResponseEntity.ok(
                servicePort.getPrograms()
        );
    }

    @PostMapping("/enrollments")
    public ResponseEntity<EnrollmentDTO> enroll(
            @RequestBody EnrollmentCmd cmd
    ) {
        return ResponseEntity.ok(
                servicePort.enroll(cmd)
        );
    }

    @PutMapping("/enrollments/{id}/progress")
    public ResponseEntity<Void> registerProgress(
            @PathVariable Long id,
            @RequestParam Double percentage
    ) {
        servicePort.registerProgress(id, percentage);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/enrollments/{id}/complete")
    public ResponseEntity<Void> completeEnrollment(
            @PathVariable Long id,
            @RequestParam Double grade
    ) {
        servicePort.completeEnrollment(id, grade);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/employee/{employeeId}")
    public ResponseEntity<List<EnrollmentDTO>> history(
            @PathVariable Long employeeId
    ) {
        return ResponseEntity.ok(
                servicePort.listByEmployee(employeeId)
        );
    }

    @GetMapping("/enrollments")
    public ResponseEntity<List<EnrollmentDTO>> getAllEnrollments() {
        return ResponseEntity.ok(
                servicePort.getAllEnrollments()
        );
    }

    // ===================================================
    // CERTIFICATIONS
    // ===================================================

    @GetMapping("/certifications")
    public ResponseEntity<List<CertificationDTO>> getCertifications() {
        return ResponseEntity.ok(
                servicePort.getCertifications()
        );
    }

    @GetMapping("/certifications/{id}")
    public ResponseEntity<CertificationDTO> getCertificationById(
            @PathVariable Long id
    ) {
        return ResponseEntity.ok(
                servicePort.getCertificationById(id)
        );
    }

}