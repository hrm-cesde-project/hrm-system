package co.edu.cesde.recruitment.infrastructure.rest;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import co.edu.cesde.recruitment.application.dto.CandidateCmd;
import co.edu.cesde.recruitment.application.port.input.CandidateServicePort;

@RestController
@RequestMapping("/api/candidates")
public class CandidateController {

    private final CandidateServicePort service;

    public CandidateController(CandidateServicePort service) {
        this.service = service;
    }

    @PostMapping
    public void create(@Valid @RequestBody CandidateCmd cmd) {
        service.createCandidate(cmd);
    }

}