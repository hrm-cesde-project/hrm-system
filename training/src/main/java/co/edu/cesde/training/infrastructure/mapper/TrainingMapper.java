package co.edu.cesde.training.infrastructure.mapper;

import co.edu.cesde.training.application.dto.CertificationDTO;
import co.edu.cesde.training.application.dto.EnrollmentDTO;
import co.edu.cesde.training.application.dto.ProgramDTO;
import co.edu.cesde.training.domain.model.Certification;
import co.edu.cesde.training.domain.model.Enrollment;
import co.edu.cesde.training.domain.model.TrainingProgram;
import co.edu.cesde.training.infrastructure.persistence.CertificationJpaEntity;
import co.edu.cesde.training.infrastructure.persistence.EnrollmentJpaEntity;
import co.edu.cesde.training.infrastructure.persistence.ProgramJpaEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TrainingMapper {

    /*
    =========================
    PROGRAM
    =========================
    */

    ProgramDTO toDTO(TrainingProgram program);

    TrainingProgram toDomain(ProgramDTO dto);

    TrainingProgram toDomain(ProgramJpaEntity entity);

    ProgramJpaEntity toEntity(TrainingProgram domain);

    /*
    =========================
    ENROLLMENT
    =========================
    */

    // ENTITY → DOMAIN
    Enrollment toDomain(EnrollmentJpaEntity entity);

    // DOMAIN → ENTITY
    EnrollmentJpaEntity toEntity(Enrollment domain);

    // DTO → DOMAIN  (ESTO ES CLAVE)
    Enrollment toDomain(EnrollmentDTO dto);

    // DOMAIN → DTO
    EnrollmentDTO toEnrollmentDTO(Enrollment domain);

    /*
    =========================
    CERTIFICATION
    =========================
    */

    CertificationDTO toCertificationDTO(Certification certification);

    Certification toDomain(CertificationJpaEntity entity);

    CertificationJpaEntity toEntity(Certification domain);
}