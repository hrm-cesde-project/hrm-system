package co.edu.cesde.recruitment.application.port.input;

import co.edu.cesde.recruitment.application.dto.CandidateCmd;
import co.edu.cesde.recruitment.application.dto.CandidateDto;
import co.edu.cesde.recruitment.domain.enums.CandidateStatus;
import java.util.List;

public interface CandidateServicePort {

    List<CandidateDto> findAll();

    CandidateDto findById(Long id);

    List<CandidateDto> findByStatus(CandidateStatus status);

    CandidateDto createCandidate(CandidateCmd cmd);

    CandidateDto advanceStatus(Long id);

    CandidateDto reject(Long id, String reason);
}
