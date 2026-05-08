package co.edu.cesde.recruitment.application.port.input;

import co.edu.cesde.recruitment.application.dto.CandidateCmd;

public interface CandidateServicePort {
    void createCandidate(CandidateCmd cmd);
}
