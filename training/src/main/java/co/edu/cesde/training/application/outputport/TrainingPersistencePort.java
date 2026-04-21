package co.edu.cesde.training.application.outputport;

import co.edu.cesde.training.domain.model.*;

import java.util.List;
import java.util.Optional;

public interface TrainingPersistencePort {

    TrainingProgram saveProgram(TrainingProgram program);

    Enrollment saveEnrollment(Enrollment enrollment);

    Optional<TrainingProgram> findProgramById(Long id);

    Optional<Enrollment> findEnrollmentById(Long id);

    List<Enrollment> findByEmployeeId(Long employeeId);

    List<TrainingProgram> findActivePrograms();
}