package co.edu.cesde.payroll.application.usecase;

import co.edu.cesde.payroll.application.inputport.PayrollServicePort;
import co.edu.cesde.payroll.application.outputport.PayrollPersistencePort;
import co.edu.cesde.payroll.domain.model.Payroll;

public class PayrollUseCase implements PayrollServicePort {

    private final PayrollPersistencePort payrollPersistencePort;

    public PayrollUseCase(PayrollPersistencePort payrollPersistencePort) {
        this.payrollPersistencePort = payrollPersistencePort;
    }

    @Override
    public Payroll createPayroll(Payroll payroll) {
        return payrollPersistencePort.save(payroll);
    }

    @Override
    public void anular(long payrollId) {

    }
}