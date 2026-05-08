package co.edu.cesde.payroll.domain;

import java.math.BigDecimal;

public class PayrollDetail {
    private long id;
    private long payrollId;
    private boolean concept;
    private String typeConcept;
    private BigDecimal value;
    private Double percentage;
    private String description;

    public PayrollDetail() {
    }

    public PayrollDetail(boolean concept, String description, long id,
                         long payrollId, Double percentage, String typeConcept, BigDecimal value) {
        this.concept = concept;
        this.description = description;
        this.id = id;
        this.payrollId = payrollId;
        this.percentage = percentage;
        this.typeConcept = typeConcept;
        this.value = value;
    }

    public boolean isConcept() {
        return concept;
    }

    public void setConcept(boolean concept) {
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

    public String getTypeConcept() {
        return typeConcept;
    }

    public void setTypeConcept(String typeConcept) {
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
                ", typeConcept='" + typeConcept + '\'' +
                ", value=" + value +
                ", percentage=" + percentage +
                ", description='" + description + '\'' +
                '}';
    }
}
