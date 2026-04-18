package co.edu.cesde.hrm.contracting.domain.model;

import co.edu.cesde.hrm.contracting.domain.enums.EstadoContrato;
import co.edu.cesde.hrm.contracting.domain.enums.TipoContrato;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Objects;

public class Contrato {

    private Long id;
    private Long empleadoId;
    private TipoContrato tipo;
    private BigDecimal salarioBase;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private EstadoContrato estado;
    private String motivoTerminacion;

    public Contrato() {
    }

    public Contrato(Long id,
                    Long empleadoId,
                    TipoContrato tipo,
                    BigDecimal salarioBase,
                    LocalDate fechaInicio,
                    LocalDate fechaFin,
                    EstadoContrato estado,
                    String motivoTerminacion) {
        this.id = id;
        this.empleadoId = empleadoId;
        this.tipo = tipo;
        this.salarioBase = salarioBase;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.estado = estado;
        this.motivoTerminacion = motivoTerminacion;
    }

    public static Contrato crearInicial(TipoContrato tipo,
                                        BigDecimal salarioBase,
                                        LocalDate fechaInicio,
                                        LocalDate fechaFin) {
        if (salarioBase == null || salarioBase.signum() <= 0) {
            throw new IllegalArgumentException("El salario base debe ser mayor a cero");
        }
        Objects.requireNonNull(tipo, "El tipo de contrato es obligatorio");
        Objects.requireNonNull(fechaInicio, "La fecha de inicio es obligatoria");

        return new Contrato(
                null,
                null,
                tipo,
                salarioBase,
                fechaInicio,
                fechaFin,
                EstadoContrato.VIGENTE,
                null
        );
    }

    public void renovar(LocalDate nuevaFechaFin) {
        this.fechaFin = nuevaFechaFin;
        this.estado = EstadoContrato.RENOVADO;
    }

    public void terminar(String motivo) {
        if (motivo == null || motivo.isBlank()) {
            throw new IllegalArgumentException("El motivo de terminación es obligatorio");
        }
        this.motivoTerminacion = motivo;
        this.estado = EstadoContrato.TERMINADO;
    }

    public boolean estaVigente() {
        return EstadoContrato.VIGENTE.equals(this.estado);
    }

    public long diasRestantes() {
        if (fechaFin == null || !estaVigente()) {
            return 0L;
        }
        return ChronoUnit.DAYS.between(LocalDate.now(), fechaFin);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getEmpleadoId() {
        return empleadoId;
    }

    public void setEmpleadoId(Long empleadoId) {
        this.empleadoId = empleadoId;
    }

    public TipoContrato getTipo() {
        return tipo;
    }

    public void setTipo(TipoContrato tipo) {
        this.tipo = tipo;
    }

    public BigDecimal getSalarioBase() {
        return salarioBase;
    }

    public void setSalarioBase(BigDecimal salarioBase) {
        this.salarioBase = salarioBase;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    public EstadoContrato getEstado() {
        return estado;
    }

    public void setEstado(EstadoContrato estado) {
        this.estado = estado;
    }

    public String getMotivoTerminacion() {
        return motivoTerminacion;
    }

    public void setMotivoTerminacion(String motivoTerminacion) {
        this.motivoTerminacion = motivoTerminacion;
    }
}
