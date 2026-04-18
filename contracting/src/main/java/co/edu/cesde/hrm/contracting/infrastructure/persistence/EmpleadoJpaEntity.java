package co.edu.cesde.hrm.contracting.infrastructure.persistence;

import co.edu.cesde.hrm.contracting.domain.enums.EstadoEmpleado;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "empleados")
public class EmpleadoJpaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long aspiranteId;

    @Column(nullable = false)
    private String nombres;

    @Column(nullable = false)
    private String apellidos;

    private String email;

    @Column(nullable = false)
    private String cargo;

    @Column(nullable = false)
    private String departamento;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EstadoEmpleado estado;

    @Column(nullable = false)
    private LocalDate fechaIngreso;

    @OneToMany(mappedBy = "empleado", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ContratoJpaEntity> contratos = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAspiranteId() {
        return aspiranteId;
    }

    public void setAspiranteId(Long aspiranteId) {
        this.aspiranteId = aspiranteId;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public EstadoEmpleado getEstado() {
        return estado;
    }

    public void setEstado(EstadoEmpleado estado) {
        this.estado = estado;
    }

    public LocalDate getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(LocalDate fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public List<ContratoJpaEntity> getContratos() {
        return contratos;
    }

    public void setContratos(List<ContratoJpaEntity> contratos) {
        this.contratos = contratos;
    }
}
