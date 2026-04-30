package co.edu.cesde.recruitment.application.usecase;

import co.edu.cesde.recruitment.application.dto.CandidateCmd;
import co.edu.cesde.recruitment.application.port.input.CandidateServicePort;
import org.springframework.stereotype.Service;

@Service
public class CandidateUseCase implements CandidateServicePort {

	@Override
	public void createCandidate(CandidateCmd cmd) {

	}
}