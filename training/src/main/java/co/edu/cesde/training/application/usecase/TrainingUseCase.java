package co.edu.cesde.training.application.usecase;

import co.edu.cesde.training.application.dto.*;
import co.edu.cesde.training.application.inputport.TrainingServicePort;
import co.edu.cesde.training.application.outputport.*;

import java.util.List;

public class TrainingUseCase implements TrainingServicePort {

    private final TrainingPersistencePort persistencePort;
    private final EmployeeQueryPort employeePort;

    public TrainingUseCase(TrainingPersistencePort persistencePort,
                           EmployeeQueryPort employeePort) {
        this.persistencePort = persistencePort;
        this.employeePort = employeePort;
    }

    @Override
    public ProgramDTO createProgram(ProgramDTO cmd) {
        return null;
    }

    @Override
    public EnrollmentDTO enroll(EnrollmentCmd cmd) {
        return null;
    }

    @Override
    public void registerProgress(Long id, Double pct) {
    }

    @Override
    public void completeEnrollment(Long id, Double grade) {
    }

    @Override
    public CertificationDTO issueCertification(Long enrollmentId) {
        return null;
    }

    @Override
    public List<EnrollmentDTO> listByEmployee(Long employeeId) {
        return null;
    }

    @Override
    public byte[] exportCSV() {
        return new byte[0];
    }
}