package co.edu.cesde.training.infrastructure.mapper;


import co.edu.cesde.training.application.dto.*;
import co.edu.cesde.training.domain.model.*;
import co.edu.cesde.training.infrastructure.persistence.*;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TrainingMapper {

    TrainingProgram toDomain(TrainingProgramJpaEntity entity);
    TrainingProgramJpaEntity toEntity(TrainingProgram domain);

    Enrollment toDomain(EnrollmentJpaEntity entity);
    EnrollmentJpaEntity toEntity(Enrollment domain);

    Certification toDomain(CertificationJpaEntity entity);
    CertificationJpaEntity toEntity(Certification domain);

    ProgramDTO toDTO(TrainingProgram domain);
    EnrollmentDTO toDTO(Enrollment domain);
    CertificationDTO toDTO(Certification domain);

    default String[] toCSVRow(Enrollment enrollment) {
        return new String[] {
                String.valueOf(enrollment.getId()),
                String.valueOf(enrollment.getEmployeeId()),
                enrollment.getEmployeeName(),
                String.valueOf(enrollment.getProgramId()),
                enrollment.getEnrollmentStatus().name(),
                String.valueOf(enrollment.getProgressPercentage()),
                String.valueOf(enrollment.getFinalGrade())
        };
    }
}