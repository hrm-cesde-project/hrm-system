package co.edu.cesde.selection.application.dto;

import java.time.LocalDateTime;

public class EntrevistaDTO {

    private Long id;
    private Long procesoId;
    private String tipo;
    private String entrevistador;
    private LocalDateTime fecha;
    private Double puntaje;
    private String observaciones;
    private Boolean aprobada;


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

        public String getTipo() {
            return tipo;
        }

        public void setTipo(String tipo) {
            this.tipo = tipo;
        }

        public String getEntrevistador() {
            return entrevistador;
        }

        public void setEntrevistador(String entrevistador) {
            this.entrevistador = entrevistador;
        }

        public LocalDateTime getFecha() {
            return fecha;
        }

        public void setFecha(LocalDateTime fecha) {
            this.fecha = fecha;
        }

        public Double getPuntaje() {
            return puntaje;
        }

        public void setPuntaje(Double puntaje) {
            this.puntaje = puntaje;
        }

        public String getObservaciones() {
            return observaciones;
        }

        public void setObservaciones(String observaciones) {
            this.observaciones = observaciones;
        }

        public Boolean getAprobada() {
            return aprobada;
        }

        public void setAprobada(Boolean aprobada) {
            this.aprobada = aprobada;
        }
    }


