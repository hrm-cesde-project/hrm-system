package co.edu.cesde.recruitment.application.usecase;

import co.edu.cesde.recruitment.application.dto.CandidateCmd;
import co.edu.cesde.recruitment.application.dto.CandidateDto;
import co.edu.cesde.recruitment.application.port.input.CandidateServicePort;
import co.edu.cesde.recruitment.application.port.output.CandidatePersistencePort;
import co.edu.cesde.recruitment.domain.enums.CandidateStatus;
import co.edu.cesde.recruitment.domain.exception.CandidateNotFoundException;
import co.edu.cesde.recruitment.domain.model.Candidate;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

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