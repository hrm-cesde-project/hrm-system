package co.edu.cesde.training.application.inputport;
import co.edu.cesde.training.application.dto.*;

import java.util.List;
public interface TrainingServicePort {
    ProgramDTO createProgram(ProgramDTO dto);

    List<ProgramDTO> getPrograms();

    EnrollmentDTO enroll(EnrollmentCmd cmd);

    void registerProgress(Long enrollmentId, Double percentage);

    void completeEnrollment(Long enrollmentId, Double grade);

    CertificationDTO issueCertification(Long enrollmentId);

    List<EnrollmentDTO> listByEmployee(Long employeeId);

    byte[] exportCSV();

    CertificationDTO getCertificationById(Long id);

    List<CertificationDTO> getCertifications();

    List<EnrollmentDTO> getAllEnrollments();
}