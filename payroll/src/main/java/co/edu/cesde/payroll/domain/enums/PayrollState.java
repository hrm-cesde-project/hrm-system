package co.edu.cesde.payroll.domain.enums;

public enum PayrollState {

    BORRADOR("Borrada"),
    LIQUIDADA("Liquidada"),
    ANULADA("Anulada ");

    private final String descripcion;

    PayrollState (String descripcion){
        this.descripcion = descripcion;
    }

    public String getDescripcion(){
        return this.descripcion;
    }

}