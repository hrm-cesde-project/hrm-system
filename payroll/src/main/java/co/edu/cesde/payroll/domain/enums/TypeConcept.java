package co.edu.cesde.payroll.domain.enums;

public enum TypeConcept {
    EARNING("Devengado"),    // DEVENGADO: Sums to the employee's total [cite: 15, 30, 31]
    DEDUCTION("Deducido");   // DEDUCCION: Subtracts from the employee's total [cite: 15, 30, 31]

    private final String descripcion;

    TypeConcept (String descripcion){
        this.descripcion = descripcion;
    }

    public String getDescripcion(){
        return this.descripcion;
    }

}
