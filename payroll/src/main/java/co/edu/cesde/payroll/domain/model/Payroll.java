package co.edu.cesde.payroll.domain.model;

import co.edu.cesde.payroll.domain.enums.PayrollState;

import java.math.BigDecimal;
import java.time.YearMonth;

public class Payroll {

    private long id;
    private long employeeId;
    private String nameEmployee;
    private YearMonth period;
    private BigDecimal baseSalary;
    private BigDecimal totalEarned;
    private BigDecimal totalDeducted;
    private BigDecimal totalToPay;
    private PayrollState type;

    public Payroll() {
    }

    public Payroll(long id, long employeeId, String nameEmployee, YearMonth period,
                   BigDecimal baseSalary, BigDecimal totalEarned, BigDecimal totalDeducted,
                   BigDecimal totalToPay, PayrollState type) {
        this.id = id;
        this.employeeId = employeeId;
        this.nameEmployee = nameEmployee;
        this.period = period;
        this.baseSalary = baseSalary;
        this.totalEarned = totalEarned;
        this.totalDeducted = totalDeducted;
        this.totalToPay = totalToPay;
        this.type = type;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(long employeeId) {
        this.employeeId = employeeId;
    }

    public String getNameEmployee() {
        return nameEmployee;
    }

    public void setNameEmployee(String nameEmployee) {
        this.nameEmployee = nameEmployee;
    }

    public YearMonth getPeriod() {
        return period;
    }

    public void setPeriod(YearMonth period) {
        this.period = period;
    }

    public BigDecimal getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(BigDecimal baseSalary) {
        this.baseSalary = baseSalary;
    }

    public BigDecimal getTotalEarned() {
        return totalEarned;
    }

    public void setTotalEarned(BigDecimal totalEarned) {
        this.totalEarned = totalEarned;
    }

    public BigDecimal getTotalDeducted() {
        return totalDeducted;
    }

    public void setTotalDeducted(BigDecimal totalDeducted) {
        this.totalDeducted = totalDeducted;
    }

    public BigDecimal getTotalToPay() {
        return totalToPay;
    }

    public void setTotalToPay(BigDecimal totalToPay) {
        this.totalToPay = totalToPay;
    }

    public PayrollState getType() {
        return type;
    }

    public void setType(PayrollState type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Payroll{" +
                "id=" + id +
                ", employeeId=" + employeeId +
                ", nameEmployee='" + nameEmployee + '\'' +
                ", period=" + period +
                ", baseSalary=" + baseSalary +
                ", totalEarned=" + totalEarned +
                ", totalDeducted=" + totalDeducted +
                ", totalToPay=" + totalToPay +
                ", type=" + type +
                '}';
    }
}