package co.edu.cesde.recruitment.controller;

import co.edu.cesde.recruitment.application.dto.CandidateCmd;
import co.edu.cesde.recruitment.application.port.input.CandidateServicePort;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/recruitment/candidates")
@RequiredArgsConstructor
public class CandidateController {

    private final CandidateServicePort candidateServicePort;

    @PostMapping
    public ResponseEntity<co.edu.cesde.recruitment.application.dto.CandidateDto> createCandidate(@Valid @RequestBody CandidateCmd cmd) {
        co.edu.cesde.recruitment.application.dto.CandidateDto dto = candidateServicePort.createCandidate(cmd);
        return ResponseEntity.status(org.springframework.http.HttpStatus.CREATED).body(dto);
    }
}