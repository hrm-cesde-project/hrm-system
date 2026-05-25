package co.edu.cesde.recruitment.repository;

import co.edu.cesde.recruitment.application.port.output.CandidatePersistencePort;
import co.edu.cesde.recruitment.domain.enums.CandidateStatus;
import co.edu.cesde.recruitment.domain.model.Candidate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class CandidatePersistenceAdapter implements CandidatePersistencePort {

    private final CandidateJpaRepository jpaRepository;

    public CandidatePersistenceAdapter(CandidateJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public List<Candidate> findAll() {
        return jpaRepository.findAll()
                .stream()
                .map(this::toDomain)
                .toList();
    }

    @Override
    public Optional<Candidate> findById(Long id) {
        return jpaRepository.findById(id).map(this::toDomain);
    }

    @Override
    public List<Candidate> findByStatus(CandidateStatus status) {
        return jpaRepository.findByStatus(status)
                .stream()
                .map(this::toDomain)
                .toList();
    }

    @Override
    public void deleteById(Long id) {
        jpaRepository.deleteById(id);
    }

    @Override
    public Candidate save(Candidate candidate) {
        CandidateEntity entity = toEntity(candidate);
        CandidateEntity saved = jpaRepository.save(entity);
        return toDomain(saved);
    }

    // ── Mappers ──────────────────────────────────────────────

    private Candidate toDomain(CandidateEntity e) {
        Candidate c = new Candidate(
                e.getFirstName(),
                e.getLastName(),
                e.getEmail(),
                e.getPhone(),
                e.getAppliedPosition(),
                e.getApplicationDate()
        );
        c.setId(e.getId());
        // Sincronizar estado y razón de rechazo desde BD
        if (e.getStatus() != null) {
            syncStatus(c, e.getStatus(), e.getRejectionReason());
        }
        return c;
    }

    private void syncStatus(Candidate c, CandidateStatus status, String rejectionReason) {
        // El dominio inicia en APPLIED; avanzamos hasta el estado almacenado
        try {
            switch (status) {
                case SCREENING -> c.advanceStatus();
                case INTERVIEW -> { c.advanceStatus(); c.advanceStatus(); }
                case REJECTED  -> c.reject(rejectionReason != null ? rejectionReason : "N/A");
                case HIRED, APPLIED -> {} // sin acción adicional
            }
        } catch (IllegalStateException ignored) {
            // Si el estado ya está sincronizado, se ignora
        }
    }

    private CandidateEntity toEntity(Candidate c) {
        CandidateEntity e = new CandidateEntity();
        e.setId(c.getId());
        e.setFirstName(c.getFirstName());
        e.setLastName(c.getLastName());
        e.setEmail(c.getEmail());
        e.setPhone(c.getPhone());
        e.setStatus(c.getStatus());
        e.setAppliedPosition(c.getAppliedPosition());
        e.setApplicationDate(c.getApplicationDate());
        e.setRejectionReason(c.getRejectionReason());
        return e;
    }
}
