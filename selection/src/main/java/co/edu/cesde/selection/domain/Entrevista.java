package co.edu.cesde.selection.domain;

import co.edu.cesde.selection.domain.enums.TipoEntrevista;

import java.time.LocalDate;

public class Entrevista {

    private Long id, procesoId;
    private TipoEntrevista tipo;
    private String entrevistador, observaciones;
    private LocalDate fecha;
    private double puntaje;
    private boolean aprobada;

    public Entrevista() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProcesoId() {
        return procesoId;
    }

    public void setProcesoId(Long procesoId) {
        this.procesoId = procesoId;
    }

    public TipoEntrevista getTipo() {
        return tipo;
    }

    public void setTipo(TipoEntrevista tipo) {
        this.tipo = tipo;
    }

    public String getEntrevistador() {
        return entrevistador;
    }

    public void setEntrevistador(String entrevistador) {
        this.entrevistador = entrevistador;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public double getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(double puntaje) {
        this.puntaje = puntaje;
    }

    public boolean isAprobada() {
        return aprobada;
    }

    public void setAprobada(boolean aprobada) {
        this.aprobada = aprobada;
    }

    public boolean estaAprobado () {
        return aprobada;
    }

    public double getPuntajePonderado () {
        return puntaje;
    }

    public void registrarResultado () {

    }


}
