package co.edu.cesde.selection.infrastructure.persistence;

import co.edu.cesde.selection.domain.enums.TipoEntrevista;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDateTime;

@Entity
@Table(name = "entrevistas")
@Getter
@Setter
@NoArgsConstructor
public class EntrevistaJpaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "proceso_id")
    private ProcesoSeleccionJpaEntity proceso;

    @Enumerated(EnumType.STRING)
    private TipoEntrevista tipo;

    private String entrevistador;
    private LocalDateTime fecha;
    private Double puntaje;
    private String observaciones;
    private boolean aprobada;
}