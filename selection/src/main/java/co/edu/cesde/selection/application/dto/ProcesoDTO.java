package co.edu.cesde.selection.application.dto;

import java.time.LocalDate;
import java.util.List;


public class ProcesoDTO {

    private Long id;
    private Long aspiranteId;
    private String nombreAspirante;
    private String cargoAplicado;
    private String estado;
    private Double puntajeFinal;
    private LocalDate fechaInicio;
    private LocalDate fechaDecision;
    private String observaciones;
    private List<EntrevistaDTO> entrevistas;


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

        public String getEstado() {
            return estado;
        }

        public void setEstado(String estado) {
            this.estado = estado;
        }

        public Double getPuntajeFinal() {
            return puntajeFinal;
        }

        public void setPuntajeFinal(Double puntajeFinal) {
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

        public String getObservaciones() {
            return observaciones;
        }

        public void setObservaciones(String observaciones) {
            this.observaciones = observaciones;
        }

        public List<EntrevistaDTO> getEntrevistas() {
            return entrevistas;
        }

        public void setEntrevistas(List<EntrevistaDTO> entrevistas) {
            this.entrevistas = entrevistas;
        }
    }


