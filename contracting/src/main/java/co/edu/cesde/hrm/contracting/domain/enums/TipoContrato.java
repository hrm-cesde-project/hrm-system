package co.edu.cesde.hrm.contracting.domain.enums;

public enum TipoContrato {
    TERMINO_FIJO,
    TERMINO_INDEFINIDO,
    OBRA_LABOR,
    APRENDIZAJE,
    PRESTACION_SERVICIOS;

    public boolean requierePeriodoPrueba() {
        return this == TERMINO_FIJO;
    }
}
