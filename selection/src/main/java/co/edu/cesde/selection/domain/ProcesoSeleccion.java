package co.edu.cesde.selection.domain;
import java.time.LocalDate;

import co.edu.cesde.selection.domain.enums.EstadoSeleccion;

public class ProcesoSeleccion {

    private Long id, aspiranteId;
    private String nombreAspirante, cargoAplicado, observaciones;
    private EstadoSeleccion estado;
    private double puntajeFinal;
    private LocalDate fechaInicio, fechaDecision;

    public ProcesoSeleccion(Long id, Long aspiranteId, String nombreAspirante, String cargoAplicado, String observaciones, EstadoSeleccion estado, double puntajeFinal, LocalDate fechaInicio, LocalDate fechaDecision) {
        this.id = id;
        this.aspiranteId = aspiranteId;
        this.nombreAspirante = nombreAspirante;
        this.cargoAplicado = cargoAplicado;
        this.observaciones = observaciones;
        this.estado = estado;
        this.puntajeFinal = puntajeFinal;
        this.fechaInicio = fechaInicio;
        this.fechaDecision = fechaDecision;
    }

    public ProcesoSeleccion() {
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

    public String getNombreAspirante() {
        return nombreAspirante;
    }

    public void setNombreAspirante(String nombreAspirante) {
        this.nombreAspirante = nombreAspirante;
    }

    public String getCargoAplicado() {
        return cargoAplicado;
    }

    public void setCargoAplicado(String cargoAplicado) {
        this.cargoAplicado = cargoAplicado;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public EstadoSeleccion getEstado() {
        return estado;
    }

    public void setEstado(EstadoSeleccion estado) {
        this.estado = estado;
    }

    public double getPuntajeFinal() {
        return puntajeFinal;
    }

    public void setPuntajeFinal(double puntajeFinal) {
        this.puntajeFinal = puntajeFinal;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaDecision() {
        return fechaDecision;
    }

    public void setFechaDecision(LocalDate fechaDecision) {
        this.fechaDecision = fechaDecision;
    }

    public void registrarEntrevista (int e) {

    }

    public void calcularPuntajeFinal () {

    }

    public void aprobar () {

    }

    public void rechazar (String motivo){

    }

    public boolean estaAprobado () {
        return false;
    }




}
