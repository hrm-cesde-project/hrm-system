package co.edu.cesde.training.application.inputport;

import co.edu.cesde.training.application.dto.*;

import java.util.List;

public interface TrainingServicePort {

    ProgramDTO createProgram(ProgramDTO cmd);

    EnrollmentDTO enroll(EnrollmentCmd cmd);

    void registerProgress(Long id, Double pct);

    void completeEnrollment(Long id, Double grade);

    CertificationDTO issueCertification(Long enrollmentId);

    List<EnrollmentDTO> listByEmployee(Long employeeId);

    byte[] exportCSV();
}