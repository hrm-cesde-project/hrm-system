package co.edu.cesde.hrm.contracting.domain.model;

import co.edu.cesde.hrm.contracting.domain.enums.EstadoEmpleado;
import co.edu.cesde.hrm.contracting.domain.enums.TipoContrato;
import co.edu.cesde.hrm.shared.dto.EmpleadoActivoDTO;

import java.util.Objects;

public class Empleado {

    private Long id;
    private Long aspiranteId;
    private String nombres;
    private String apellidos;
    private String email;
    private String cargo;
    private String departamento;
    private EstadoEmpleado estado;
    private java.time.LocalDate fechaIngreso;

    public Empleado() {
    }

    public Empleado(Long id,
                    Long aspiranteId,
                    String nombres,
                    String apellidos,
                    String email,
                    String cargo,
                    String departamento,
                    EstadoEmpleado estado,
                    java.time.LocalDate fechaIngreso) {
        this.id = id;
        this.aspiranteId = aspiranteId;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.email = email;
        this.cargo = cargo;
        this.departamento = departamento;
        this.estado = estado;
        this.fechaIngreso = fechaIngreso;
    }

    public static Empleado contratar(Long aspiranteId,
                                     String nombres,
                                     String apellidos,
                                     String email,
                                     String cargo,
                                     String departamento,
                                     java.time.LocalDate fechaIngreso,
                                     TipoContrato tipoContrato) {
        Objects.requireNonNull(aspiranteId, "El aspiranteId es obligatorio");
        Objects.requireNonNull(fechaIngreso, "La fecha de ingreso es obligatoria");
        Objects.requireNonNull(tipoContrato, "El tipo de contrato es obligatorio");

        return new Empleado(
                null,
                aspiranteId,
                nombres == null || nombres.isBlank() ? "Pendiente" : nombres.trim(),
                apellidos == null ? "" : apellidos.trim(),
                email == null ? "" : email.trim(),
                cargo,
                departamento,
                tipoContrato.requierePeriodoPrueba() ? EstadoEmpleado.EN_PERIODO_PRUEBA : EstadoEmpleado.ACTIVO,
                fechaIngreso
        );
    }

    public void activar() {
        this.estado = EstadoEmpleado.ACTIVO;
    }

    public void suspender() {
        this.estado = EstadoEmpleado.SUSPENDIDO;
    }

    public void retirar(String motivo) {
        this.estado = EstadoEmpleado.RETIRADO;
    }

    public boolean estaActivo() {
        return EstadoEmpleado.ACTIVO.equals(this.estado) || EstadoEmpleado.EN_PERIODO_PRUEBA.equals(this.estado);
    }

    public EmpleadoActivoDTO toEmpleadoActivoDTO(java.math.BigDecimal salarioBase) {
        return new EmpleadoActivoDTO(
                id,
                (nombres + " " + apellidos).trim(),
                cargo,
                departamento,
                salarioBase
        );
    }

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

    public java.time.LocalDate getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(java.time.LocalDate fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }
}
