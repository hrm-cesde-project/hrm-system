package co.edu.cesde.recruitment.controller;

import co.edu.cesde.recruitment.application.dto.CandidateAnalyticsDto;
import co.edu.cesde.recruitment.application.dto.CandidateCmd;
import co.edu.cesde.recruitment.application.dto.CandidateDto;
import co.edu.cesde.recruitment.application.dto.StatusRequest;
import co.edu.cesde.recruitment.application.port.input.CandidateServicePort;
import co.edu.cesde.recruitment.domain.enums.CandidateStatus;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/recruitment/candidates")
@RequiredArgsConstructor
public class CandidateController {

    private final CandidateServicePort candidateServicePort;

    @PostMapping
    public ResponseEntity<CandidateDto> createCandidate(@Valid @RequestBody CandidateCmd cmd) {
        CandidateDto dto = candidateServicePort.createCandidate(cmd);
        return ResponseEntity.status(HttpStatus.CREATED).body(dto);
    }

    @GetMapping
    public ResponseEntity<List<CandidateDto>> getAllCandidates() {
        return ResponseEntity.ok(candidateServicePort.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CandidateDto> getCandidateById(@PathVariable Long id) {
        return ResponseEntity.ok(candidateServicePort.findById(id));
    }

    @PatchMapping("/{id}/status")
    public ResponseEntity<CandidateDto> updateStatus(@PathVariable Long id,
                                                     @Valid @RequestBody StatusRequest request) {
        CandidateDto dto = switch (request.getAction()) {
            case ADVANCE -> candidateServicePort.advanceStatus(id);
            case REJECT -> candidateServicePort.reject(id, request.getReason());
        };
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCandidate(@PathVariable Long id) {
        candidateServicePort.deleteCandidate(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/export/csv")
    public ResponseEntity<byte[]> exportCsv() {
        byte[] csv = candidateServicePort.exportCsv();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        headers.setContentDisposition(org.springframework.http.ContentDisposition.attachment().filename("candidates.csv").build());
        return ResponseEntity.ok().headers(headers).body(csv);
    }

    @GetMapping("/analytics")
    public ResponseEntity<CandidateAnalyticsDto> getAnalytics() {
        return ResponseEntity.ok(candidateServicePort.getAnalytics());
    }
}
