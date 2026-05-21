package co.edu.cesde.training.application.outputport;
import co.edu.cesde.training.application.dto.ProgramDTO;
import co.edu.cesde.training.domain.model.*;

import java.util.List;
import java.util.Optional;
public interface TrainingPersistencePort {
    TrainingProgram saveProgram(TrainingProgram program);

    Enrollment saveEnrollment(Enrollment enrollment);

    Certification saveCertification(Certification certification);

    Optional<TrainingProgram> findProgramById(Long id);

    Optional<Enrollment> findEnrollmentById(Long id);

    List<Enrollment> findByEmployeeId(Long id);

    List<TrainingProgram> findActivePrograms();

    List<TrainingProgram> findAllPrograms();

    List<ProgramDTO> getPrograms();

    Optional<Certification> findCertificationById(Long id);

    List<Certification> getCertifications();

    List<Enrollment> findAllEnrollments();
}