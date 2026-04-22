package co.edu.cesde.recruitment.infrastructure.persistence;

import co.edu.cesde.recruitment.application.port.output.CandidatePersistencePort;
import co.edu.cesde.recruitment.domain.model.Candidate;
import org.springframework.stereotype.Component;

@Component
public class CandidatePersistenceAdapter implements CandidatePersistencePort {

    @Override
    public void save(Candidate candidate) {

    }

}