package co.edu.cesde.recruitment.domain.exception;

public class CandidateNotFoundException extends RuntimeException {

    public CandidateNotFoundException(Long id) {
        super("Candidate not found with id: " + id);
    }
}
