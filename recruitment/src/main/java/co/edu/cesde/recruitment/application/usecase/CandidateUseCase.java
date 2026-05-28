package co.edu.cesde.recruitment.application.usecase;

import co.edu.cesde.recruitment.application.dto.CandidateAnalyticsDto;
import co.edu.cesde.recruitment.application.dto.CandidateCmd;
import co.edu.cesde.recruitment.application.dto.CandidateDto;
import co.edu.cesde.recruitment.application.port.input.CandidateServicePort;
import co.edu.cesde.recruitment.application.port.output.CandidatePersistencePort;
import co.edu.cesde.recruitment.domain.enums.CandidateStatus;
import co.edu.cesde.recruitment.domain.exception.CandidateNotFoundException;
import co.edu.cesde.recruitment.domain.model.Candidate;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class CandidateUseCase implements CandidateServicePort {

    private final CandidatePersistencePort persistencePort;

    public CandidateUseCase(CandidatePersistencePort persistencePort) {
        this.persistencePort = persistencePort;
    }

    @Override
    public List<CandidateDto> findAll() {
        return persistencePort.findAll()
                .stream()
                .sorted(Comparator.comparing(
                        Candidate::getApplicationDate,
                        Comparator.nullsLast(Comparator.reverseOrder())
                ))
                .map(this::toDTO)
                .toList();
    }

    @Override
    public CandidateDto findById(Long id) {
        return persistencePort.findById(id)
                .map(this::toDTO)
                .orElseThrow(() -> new CandidateNotFoundException(id));
    }

    @Override
    public List<CandidateDto> findByStatus(CandidateStatus status) {
        return persistencePort.findByStatus(status)
                .stream()
                .sorted(Comparator.comparing(
                        Candidate::getApplicationDate,
                        Comparator.nullsLast(Comparator.reverseOrder())
                ))
                .map(this::toDTO)
                .toList();
    }

    @Override
    public CandidateDto createCandidate(CandidateCmd cmd) {
        Candidate candidate = new Candidate(
                cmd.getFirstName(),
                cmd.getLastName(),
                cmd.getEmail(),
                cmd.getPhone(),
                cmd.getAppliedPosition(),
                cmd.getApplicationDate()
        );
        return toDTO(persistencePort.save(candidate));
    }

    @Override
    public CandidateDto advanceStatus(Long id) {
        Candidate candidate = persistencePort.findById(id)
                .orElseThrow(() -> new CandidateNotFoundException(id));
        candidate.advanceStatus();
        return toDTO(persistencePort.save(candidate));
    }

    @Override
    public CandidateDto reject(Long id, String reason) {
        Candidate candidate = persistencePort.findById(id)
                .orElseThrow(() -> new CandidateNotFoundException(id));
        candidate.reject(reason);
        return toDTO(persistencePort.save(candidate));
    }

    @Override
    public void deleteCandidate(Long id) {
        persistencePort.findById(id)
                .orElseThrow(() -> new CandidateNotFoundException(id));
        persistencePort.deleteById(id);
    }

    @Override
    public byte[] exportCsv() {
        List<Candidate> candidates = persistencePort.findAll();
        try (ByteArrayOutputStream baos = new ByteArrayOutputStream();
             OutputStreamWriter writer = new OutputStreamWriter(baos, StandardCharsets.UTF_8);
             CSVPrinter printer = new CSVPrinter(writer, CSVFormat.DEFAULT
                     .withHeader("ID", "First Name", "Last Name", "Email", "Phone",
                             "Status", "Applied Position", "Application Date", "Rejection Reason"))) {

            for (Candidate c : candidates) {
                printer.printRecord(
                        c.getId(),
                        c.getFirstName(),
                        c.getLastName(),
                        c.getEmail(),
                        c.getPhone(),
                        c.getStatus(),
                        c.getAppliedPosition(),
                        c.getApplicationDate(),
                        c.getRejectionReason()
                );
            }
            printer.flush();
            return baos.toByteArray();
        } catch (Exception e) {
            throw new RuntimeException("Failed to generate CSV", e);
        }
    }

    @Override
    public CandidateAnalyticsDto getAnalytics() {
        List<Candidate> candidates = persistencePort.findAll();
        long total = candidates.size();

        Map<String, Long> byStatus = candidates.stream()
                .collect(Collectors.groupingBy(
                        c -> c.getStatus().name(),
                        LinkedHashMap::new,
                        Collectors.counting()
                ));

        for (CandidateStatus status : CandidateStatus.values()) {
            byStatus.putIfAbsent(status.name(), 0L);
        }

        return new CandidateAnalyticsDto(total, byStatus);
    }

    // Internal mapper — domain → DTO
    private CandidateDto toDTO(Candidate c) {
        return new CandidateDto(
                c.getId(),
                c.getFirstName(),
                c.getLastName(),
                c.getEmail(),
                c.getPhone(),
                c.getStatus(),
                c.getAppliedPosition(),
                c.getApplicationDate(),
                c.getRejectionReason()
        );
    }
}
