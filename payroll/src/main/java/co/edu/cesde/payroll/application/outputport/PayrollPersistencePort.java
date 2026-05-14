package co.edu.cesde.payroll.application.outputport;

import co.edu.cesde.payroll.domain.Payroll;

public interface PayrollPersistencePort {
    Payroll save(Payroll payroll);
}
