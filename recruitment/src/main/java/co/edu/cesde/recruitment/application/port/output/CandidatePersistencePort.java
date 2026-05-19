package co.edu.cesde.recruitment.application.port.output;

import co.edu.cesde.recruitment.domain.enums.CandidateStatus;
import co.edu.cesde.recruitment.domain.model.Candidate;
import java.util.List;
import java.util.Optional;

import java.util.List;
import java.util.Optional;

public interface CandidatePersistencePort {

    List<Candidate> findAll();

    Optional<Candidate> findById(Long id);

    List<Candidate> findByStatus(CandidateStatus status);

    Candidate save(Candidate candidate);
}
