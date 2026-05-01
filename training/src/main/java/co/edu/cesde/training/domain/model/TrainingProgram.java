package co.edu.cesde.training.domain.model;

import co.edu.cesde.training.domain.enums.*;

        import java.time.LocalDate;

public class TrainingProgram {
    private Long id;
    private String name;
    private String description;
    private ProgramType type;
    private Modality modality;
    private int durationHours;
    private LocalDate startDate;
    private LocalDate endDate;
    private boolean active;

    public TrainingProgram() {}

    public TrainingProgram(Long id, String name, String description, ProgramType type,
                           Modality modality, int durationHours, LocalDate startDate,
                           LocalDate endDate, boolean active) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.type = type;
        this.modality = modality;
        this.durationHours = durationHours;
        this.startDate = startDate;
        this.endDate = endDate;
        this.active = active;
    }

    public Long getId() {return id;}
    public void setId(Long id) {this.id = id;}

    public String getName() {return name;}
    public void setName(String name) {this.name = name;}

    public String getDescription() {return description;}
    public void setDescription(String description) {this.description = description;}

    public ProgramType getType() {return type;}
    public void setType(ProgramType type) {this.type = type;}

    public Modality getModality() {return modality;}
    public void setModality(Modality modality) {this.modality = modality;}

    public int getDurationHours() {return durationHours;}
    public void setDurationHours(int durationHours) {this.durationHours = durationHours;}

    public LocalDate getStartDate() {return startDate;}
    public void setStartDate(LocalDate startDate) {this.startDate = startDate;}

    public LocalDate getEndDate() {return endDate;}
    public void setEndDate(LocalDate endDate) {this.endDate = endDate;}

    public boolean isActive() {return active;}
    public void setActive(boolean active) {this.active = active;}

    @Override
    public String toString() {
        return "TrainingProgram{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", type=" + type +
                ", modality=" + modality +
                ", durationHours=" + durationHours +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", active=" + active +
                '}';
    }
}
