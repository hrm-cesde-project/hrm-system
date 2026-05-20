package co.edu.cesde.training.application.usecase;

import co.edu.cesde.training.application.dto.CertificationDTO;
import co.edu.cesde.training.application.dto.EnrollmentCmd;
import co.edu.cesde.training.application.dto.EnrollmentDTO;
import co.edu.cesde.training.application.dto.ProgramDTO;
import co.edu.cesde.training.application.inputport.TrainingServicePort;
import co.edu.cesde.training.application.outputport.EmployeeQueryPort;
import co.edu.cesde.training.application.outputport.TrainingPersistencePort;
import co.edu.cesde.training.domain.enums.EnrollmentStatus;
import co.edu.cesde.training.domain.model.Certification;
import co.edu.cesde.training.domain.model.Enrollment;
import co.edu.cesde.training.domain.model.TrainingProgram;
import co.edu.cesde.training.infrastructure.mapper.TrainingMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class TrainingUseCase implements TrainingServicePort {

    private final TrainingPersistencePort persistencePort;
    private final EmployeeQueryPort employeePort;
    private final TrainingMapper mapper;

    public TrainingUseCase(
            TrainingPersistencePort persistencePort,
            EmployeeQueryPort employeePort,
            TrainingMapper mapper
    ) {
        this.persistencePort = persistencePort;
        this.employeePort = employeePort;
        this.mapper = mapper;
    }

    // =========================
    // PROGRAMS
    // =========================

    @Override
    public List<ProgramDTO> getPrograms() {
        return persistencePort.getPrograms();
    }

    @Override
    public ProgramDTO createProgram(ProgramDTO dto) {

        if (dto.getEndDate().isBefore(dto.getStartDate())) {
            throw new RuntimeException("End date must be after start date");
        }

        TrainingProgram program = mapper.toDomain(dto);
        program.setActive(true);

        return mapper.toDTO(
                persistencePort.saveProgram(program)
        );
    }

    // =========================
    // ENROLLMENTS
    // =========================

    @Override
    public EnrollmentDTO enroll(EnrollmentCmd cmd) {

        boolean active = employeePort.findActiveEmployee(cmd.getEmployeeId());

        if (!active) {
            throw new RuntimeException("Employee not active");
        }

        TrainingProgram program = persistencePort
                .findProgramById(cmd.getProgramId())
                .orElseThrow(() -> new RuntimeException("Program not found"));

        if (!program.isActive()) {
            throw new RuntimeException("Program inactive");
        }

        Enrollment enrollment = new Enrollment();
        enrollment.setEmployeeId(cmd.getEmployeeId());
        enrollment.setEmployeeName(cmd.getEmployeeName());
        enrollment.setProgramId(cmd.getProgramId());
        enrollment.setEnrollmentStatus(EnrollmentStatus.ENROLLED);
        enrollment.setRegistrationDate(LocalDate.now());
        enrollment.setProgressPercentage(0.0);

        return mapper.toEnrollmentDTO(
                persistencePort.saveEnrollment(enrollment)
        );
    }

    @Override
    public List<EnrollmentDTO> getAllEnrollments() {
        return persistencePort.findAllEnrollments()
                .stream()
                .map(mapper::toEnrollmentDTO)
                .toList();
    }

    @Override
    public List<EnrollmentDTO> listByEmployee(Long employeeId) {
        return persistencePort.findByEmployeeId(employeeId)
                .stream()
                .map(mapper::toEnrollmentDTO)
                .toList();
    }

    // =========================
    // PROGRESS
    // =========================

    @Override
    public void registerProgress(Long id, Double percentage) {

        Enrollment enrollment = persistencePort
                .findEnrollmentById(id)
                .orElseThrow(() -> new RuntimeException("Enrollment not found"));

        if (percentage < 0 || percentage > 100) {
            throw new RuntimeException("Invalid percentage");
        }

        if (percentage < enrollment.getProgressPercentage()) {
            throw new RuntimeException("Progress cannot decrease");
        }

        enrollment.setProgressPercentage(percentage);

        if (percentage > 0) {
            enrollment.setEnrollmentStatus(EnrollmentStatus.IN_PROGRESS);
        }

        persistencePort.saveEnrollment(enrollment);
    }

    @Override
    public void completeEnrollment(Long id, Double grade) {

        Enrollment enrollment = persistencePort
                .findEnrollmentById(id)
                .orElseThrow(() -> new RuntimeException("Enrollment not found"));

        if (grade < 0 || grade > 5) {
            throw new RuntimeException("Invalid grade");
        }

        enrollment.setFinalGrade(grade);

        if (grade >= 3.0) {

            enrollment.setEnrollmentStatus(EnrollmentStatus.COMPLETED);

            TrainingProgram program = persistencePort
                    .findProgramById(enrollment.getProgramId())
                    .orElseThrow(() -> new RuntimeException("Program not found"));

            Certification certification = new Certification();
            certification.setEnrollmentId(enrollment.getId());
            certification.setEmployeeId(enrollment.getEmployeeId());
            certification.setProgramName(program.getName());
            certification.setIssueDate(LocalDate.now());
            certification.setVerificationCode(UUID.randomUUID().toString());

            persistencePort.saveCertification(certification);

        } else {
            enrollment.setEnrollmentStatus(EnrollmentStatus.FAILED);
        }

        persistencePort.saveEnrollment(enrollment);
    }

    // =========================
    // CERTIFICATIONS
    // =========================

    @Override
    public List<CertificationDTO> getCertifications() {
        return persistencePort.getCertifications()
                .stream()
                .map(mapper::toCertificationDTO)
                .toList();
    }

    @Override
    public CertificationDTO getCertificationById(Long id) {

        Certification certification = persistencePort
                .findCertificationById(id)
                .orElseThrow(() -> new RuntimeException("Certification not found"));

        return mapper.toCertificationDTO(certification);
    }

    @Override
    public CertificationDTO issueCertification(Long enrollmentId) {
        return null; // si no lo usas, lo dejamos así
    }

    @Override
    public byte[] exportCSV() {
        return new byte[0];
    }
}