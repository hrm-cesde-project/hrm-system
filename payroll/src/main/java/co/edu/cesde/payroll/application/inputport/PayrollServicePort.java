package co.edu.cesde.payroll.application.inputport;

import co.edu.cesde.payroll.domain.Payroll;


public interface PayrollServicePort {
    Payroll createPayroll(Payroll payroll);
}
