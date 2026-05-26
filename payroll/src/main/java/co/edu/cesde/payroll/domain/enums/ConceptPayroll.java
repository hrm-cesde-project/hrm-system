package co.edu.cesde.payroll.domain.enums;

public enum ConceptPayroll {
    BASIC_SALARY("SALARIO_BASICO"),       // SALARIO_BASICO
    TRANSPORT_ALLOWANCE("Auxilio de transporte"), // AUXILIO_TRANSPORTE (if salary < 2 SMMLV) [cite: 14, 31]
    OVERTIME("Horas Extra"),           // HORAS_EXTRA
    HEALTH_INSURANCE("Salud"),   // SALUD (4% deduction) [cite: 14, 31]
    PENSION_FUND("Pension"),       // PENSION (4% deduction) [cite: 14, 31]
    WITHHOLDING_TAX("deduccion Variable");     // RETENCION_FUENTE

    private final String descripcion;

    ConceptPayroll (String descripcion){
        this.descripcion = descripcion;
    }

    public String getDescripcion(){
        return this.descripcion;
    }

}
