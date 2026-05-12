package co.edu.cesde.recruitment.controller;

import co.edu.cesde.recruitment.application.dto.CandidateCmd;
import co.edu.cesde.recruitment.application.port.input.CandidateServicePort;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/recruitment/candidates")
public class CandidateController {

    private final CandidateServicePort candidateServicePort;

    public CandidateController(CandidateServicePort candidateServicePort) {
        this.candidateServicePort = candidateServicePort;
    }

    @PostMapping
    public ResponseEntity<Void> createCandidate(@Valid @RequestBody CandidateCmd candidateCmd) {
        candidateServicePort.createCandidate(candidateCmd);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
