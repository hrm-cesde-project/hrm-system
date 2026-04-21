package co.edu.cesde.training.infrastructure.persistence;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
@Table(name = "training_programs")
public class TrainingProgramJpaEntity {

    @Id
    private Long id;

    private String name;
    private String type;
    private String modality;
    private int durationHours;
    private boolean active;

    private LocalDate startDate;
    private LocalDate endDate;
}