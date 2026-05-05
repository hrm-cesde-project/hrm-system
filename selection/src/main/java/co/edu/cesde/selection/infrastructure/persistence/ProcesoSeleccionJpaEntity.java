package co.edu.cesde.selection.infrastructure.persistence;

import co.edu.cesde.selection.domain.enums.EstadoSeleccion;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "procesos_seleccion")
@Getter
@Setter
@NoArgsConstructor
public class ProcesoSeleccionJpaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long aspiranteId;
    private String nombreAspirante;
    private String cargoAplicado;

    @Enumerated(EnumType.STRING)
    private EstadoSeleccion estado;

    private Double puntajeFinal;
    private LocalDate fechaInicio;
    private LocalDate fechaDecision;
    private String observaciones;

    @OneToMany(mappedBy = "proceso", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<EntrevistaJpaEntity> entrevistas;
}