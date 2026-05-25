package co.edu.cesde.training.infrastructure.persistence;

import co.edu.cesde.training.application.dto.ProgramDTO;
import co.edu.cesde.training.application.outputport.TrainingPersistencePort;
import co.edu.cesde.training.domain.model.Certification;
import co.edu.cesde.training.domain.model.Enrollment;
import co.edu.cesde.training.domain.model.TrainingProgram;
import co.edu.cesde.training.infrastructure.mapper.TrainingMapper;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@Transactional
public class TrainingPersistenceAdapter implements TrainingPersistencePort {

    private final TrainingMapper mapper;

    @PersistenceContext
    private EntityManager entityManager;

    public TrainingPersistenceAdapter(TrainingMapper mapper) {
        this.mapper = mapper;
    }

    // =========================
    // PROGRAMS
    // =========================

    @Override
    public TrainingProgram saveProgram(TrainingProgram program) {
        ProgramJpaEntity entity = mapper.toEntity(program);

        if (entity.getId() == null) {
            entityManager.persist(entity);
        } else {
            entity = entityManager.merge(entity);
        }

        return mapper.toDomain(entity);
    }

    @Override
    public void deleteProgram(Long id) {
        ProgramJpaEntity entity =
                entityManager.find(ProgramJpaEntity.class, id);

        if (entity == null) {
            throw new RuntimeException("Program not found");
        }

        entityManager.remove(entity);
    }

    @Override
    public Optional<TrainingProgram> findProgramById(Long id) {
        ProgramJpaEntity entity =
                entityManager.find(ProgramJpaEntity.class, id);

        return entity == null
                ? Optional.empty()
                : Optional.of(mapper.toDomain(entity));
    }

    @Override
    public List<TrainingProgram> findActivePrograms() {
        return entityManager.createQuery(
                        "SELECT p FROM ProgramJpaEntity p WHERE p.active = true",
                        ProgramJpaEntity.class
                )
                .getResultList()
                .stream()
                .map(mapper::toDomain)
                .toList();
    }

    @Override
    public List<TrainingProgram> findAllPrograms() {
        return entityManager.createQuery(
                        "SELECT p FROM ProgramJpaEntity p",
                        ProgramJpaEntity.class
                )
                .getResultList()
                .stream()
                .map(mapper::toDomain)
                .toList();
    }

    @Override
    public List<ProgramDTO> getPrograms() {
        return entityManager.createQuery(
                        "SELECT p FROM ProgramJpaEntity p",
                        ProgramJpaEntity.class
                )
                .getResultList()
                .stream()
                .map(mapper::toDomain)
                .map(mapper::toDTO)
                .toList();
    }

    // =========================
    // ENROLLMENTS (FIX HERE 🔥)
    // =========================

    @Override
    public Enrollment saveEnrollment(Enrollment enrollment) {
        EnrollmentJpaEntity entity = mapper.toEntity(enrollment);

        if (entity.getId() == null) {
            entityManager.persist(entity);
        } else {
            entity = entityManager.merge(entity);
        }

        return mapper.toDomain(entity);
    }

    @Override
    public Optional<Enrollment> findEnrollmentById(Long id) {
        EnrollmentJpaEntity entity =
                entityManager.find(EnrollmentJpaEntity.class, id);

        return entity == null
                ? Optional.empty()
                : Optional.of(mapper.toDomain(entity));
    }

    @Override
    public List<Enrollment> findByEmployeeId(Long id) {
        return entityManager.createQuery(
                        "SELECT e FROM EnrollmentJpaEntity e WHERE e.employeeId = :employeeId",
                        EnrollmentJpaEntity.class
                )
                .setParameter("employeeId", id)
                .getResultList()
                .stream()
                .map(mapper::toDomain)
                .toList();
    }

    @Override
    public List<Enrollment> findAllEnrollments() {
        return entityManager.createQuery(
                        "SELECT e FROM EnrollmentJpaEntity e",
                        EnrollmentJpaEntity.class
                )
                .getResultList()
                .stream()
                .map(mapper::toDomain)
                .toList();
    }

    // =========================
    // CERTIFICATIONS
    // =========================

    @Override
    public Certification saveCertification(Certification certification) {
        CertificationJpaEntity entity = mapper.toEntity(certification);

        if (entity.getId() == null) {
            entityManager.persist(entity);
        } else {
            entity = entityManager.merge(entity);
        }

        return mapper.toDomain(entity);
    }

    @Override
    public List<Certification> getCertifications() {
        return entityManager.createQuery(
                        "SELECT c FROM CertificationJpaEntity c",
                        CertificationJpaEntity.class
                )
                .getResultList()
                .stream()
                .map(mapper::toDomain)
                .toList();
    }

    @Override
    public Optional<Certification> findCertificationById(Long id) {
        CertificationJpaEntity entity =
                entityManager.find(CertificationJpaEntity.class, id);

        return entity == null
                ? Optional.empty()
                : Optional.of(mapper.toDomain(entity));
    }
}