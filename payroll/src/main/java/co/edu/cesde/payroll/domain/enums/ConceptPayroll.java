package co.edu.cesde.payroll.domain.enums;

public enum ConceptPayroll {
    BASIC_SALARY,       // SALARIO_BASICO
    TRANSPORT_ALLOWANCE, // AUXILIO_TRANSPORTE (if salary < 2 SMMLV) [cite: 14, 31]
    OVERTIME,           // HORAS_EXTRA
    HEALTH_INSURANCE,   // SALUD (4% deduction) [cite: 14, 31]
    PENSION_FUND,       // PENSION (4% deduction) [cite: 14, 31]
    WITHHOLDING_TAX     // RETENCION_FUENTE

}
