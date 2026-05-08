package co.edu.cesde.payroll.domain;

import java.math.BigDecimal;
import java.time.YearMonth;

public class Payroll {
    private long id;
    private long employeId;
    private String nameEmploye;
    private YearMonth period;
    private BigDecimal baseSalary;
    private BigDecimal totalEarned;
    private BigDecimal totalDeducted;
    private BigDecimal totalToPay;
    private boolean state;

    public Payroll() {
    }

    public Payroll(BigDecimal baseSalary, long employeId, long id, String nameEmploye,
                   YearMonth period, boolean state, BigDecimal totalDeducted,
                   BigDecimal totalEarned, BigDecimal totalToPay) {
        this.baseSalary = baseSalary;
        this.employeId = employeId;
        this.id = id;
        this.nameEmploye = nameEmploye;
        this.period = period;
        this.state = state;
        this.totalDeducted = totalDeducted;
        this.totalEarned = totalEarned;
        this.totalToPay = totalToPay;
    }

    public BigDecimal getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(BigDecimal baseSalary) {
        this.baseSalary = baseSalary;
    }

    public long getEmployeId() {
        return employeId;
    }

    public void setEmployeId(long employeId) {
        this.employeId = employeId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNameEmploye() {
        return nameEmploye;
    }

    public void setNameEmploye(String nameEmploye) {
        this.nameEmploye = nameEmploye;
    }

    public YearMonth getPeriod() {
        return period;
    }

    public void setPeriod(YearMonth period) {
        this.period = period;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public BigDecimal getTotalDeducted() {
        return totalDeducted;
    }

    public void setTotalDeducted(BigDecimal totalDeducted) {
        this.totalDeducted = totalDeducted;
    }

    public BigDecimal getTotalEarned() {
        return totalEarned;
    }

    public void setTotalEarned(BigDecimal totalEarned) {
        this.totalEarned = totalEarned;
    }

    public BigDecimal getTotalToPay() {
        return totalToPay;
    }

    public void setTotalToPay(BigDecimal totalToPay) {
        this.totalToPay = totalToPay;
    }

    @Override
    public String toString() {
        return "Payroll{" +
                "baseSalary=" + baseSalary +
                ", id=" + id +
                ", employeId=" + employeId +
                ", nameEmploye='" + nameEmploye + '\'' +
                ", period=" + period +
                ", totalEarned=" + totalEarned +
                ", totalDeducted=" + totalDeducted +
                ", totalToPay=" + totalToPay +
                ", state=" + state +
                '}';
    }
}
