package co.edu.cesde.payroll.application.inputport;

import co.edu.cesde.payroll.application.dto.PayrollDTO;
import co.edu.cesde.payroll.domain.enums.PayrollState;

import java.util.List;


public interface PayrollServicePort {
    PayrollDTO createPayroll ();
    void addPayroll ();
    PayrollDTO liquidar (long payrollId);
    void anular (long payrollId, String motivo);
    List<PayrollDTO> buscarEmpleado (long id);
    List<PayrollDTO> buscarPoePeriodo ();
    Byte[] exportCSV ();
    Byte[] exportCSVconsolidado ();



}
