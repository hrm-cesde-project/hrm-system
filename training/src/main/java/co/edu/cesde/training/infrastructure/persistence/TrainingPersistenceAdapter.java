package co.edu.cesde.training.infrastructure.persistence;

import co.edu.cesde.training.application.outputport.TrainingPersistencePort;
import co.edu.cesde.training.domain.model.*;

import java.util.List;
import java.util.Optional;

public class TrainingPersistenceAdapter implements TrainingPersistencePort {

    @Override
    public TrainingProgram saveProgram(TrainingProgram program) { return null; }

    @Override
    public Enrollment saveEnrollment(Enrollment enrollment) { return null; }

    @Override
    public Optional<TrainingProgram> findProgramById(Long id) { return Optional.empty(); }

    @Override
    public Optional<Enrollment> findEnrollmentById(Long id) { return Optional.empty(); }

    @Override
    public List<Enrollment> findByEmployeeId(Long employeeId) { return List.of(); }

    @Override
    public List<TrainingProgram> findActivePrograms() { return List.of(); }
}