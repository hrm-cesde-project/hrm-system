package co.edu.cesde.recruitment.application.port.output;

import co.edu.cesde.recruitment.domain.model.Candidate;

public interface CandidatePersistencePort {
    void save(Candidate candidate);


}
