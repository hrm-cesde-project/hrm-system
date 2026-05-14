package co.edu.cesde.payroll.domain;

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
    private PayrollState state;

    public Payroll() {
    }

    public Payroll(BigDecimal baseSalary,
                   long employeeId,
                   long id,
                   String nameEmployee,
                   YearMonth period,
                   PayrollState state,
                   BigDecimal totalDeducted,
                   BigDecimal totalEarned,
                   BigDecimal totalToPay) {

        this.baseSalary = baseSalary;
        this.employeeId = employeeId;
        this.id = id;
        this.nameEmployee = nameEmployee;
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

    public long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(long employeeId) {
        this.employeeId = employeeId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public PayrollState getState() {
        return state;
    }

    public void setState(PayrollState state) {
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
                ", employeeId=" + employeeId +
                ", nameEmployee='" + nameEmployee + '\'' +
                ", period=" + period +
                ", totalEarned=" + totalEarned +
                ", totalDeducted=" + totalDeducted +
                ", totalToPay=" + totalToPay +
                ", state=" + state +
                '}';
    }
}