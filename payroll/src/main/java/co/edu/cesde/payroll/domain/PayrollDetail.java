package co.edu.cesde.payroll.domain;

import co.edu.cesde.payroll.domain.enums.ConceptPayroll;
import co.edu.cesde.payroll.domain.enums.TypeConcept;

import java.math.BigDecimal;

public class PayrollDetail {

    private long id;
    private long payrollId;
    private ConceptPayroll concept;
    private TypeConcept typeConcept;
    private BigDecimal value;
    private Double percentage;
    private String description;

    public PayrollDetail() {
    }

    public PayrollDetail(ConceptPayroll concept,
                         String description,
                         long id,
                         long payrollId,
                         Double percentage,
                         TypeConcept typeConcept,
                         BigDecimal value) {

        this.concept = concept;
        this.description = description;
        this.id = id;
        this.payrollId = payrollId;
        this.percentage = percentage;
        this.typeConcept = typeConcept;
        this.value = value;
    }

    public ConceptPayroll getConcept() {
        return concept;
    }

    public void setConcept(ConceptPayroll concept) {
        this.concept = concept;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getPayrollId() {
        return payrollId;
    }

    public void setPayrollId(long payrollId) {
        this.payrollId = payrollId;
    }

    public Double getPercentage() {
        return percentage;
    }

    public void setPercentage(Double percentage) {
        this.percentage = percentage;
    }

    public TypeConcept getTypeConcept() {
        return typeConcept;
    }

    public void setTypeConcept(TypeConcept typeConcept) {
        this.typeConcept = typeConcept;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "PayrollDetail{" +
                "concept=" + concept +
                ", id=" + id +
                ", payrollId=" + payrollId +
                ", typeConcept=" + typeConcept +
                ", value=" + value +
                ", percentage=" + percentage +
                ", description='" + description + '\'' +
                '}';
    }
}