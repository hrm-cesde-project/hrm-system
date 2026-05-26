package co.edu.cesde.payroll.application.outputport;

import co.edu.cesde.payroll.application.dto.PayrollDTO;
import co.edu.cesde.payroll.domain.enums.PayrollState;
import co.edu.cesde.payroll.domain.model.Payroll;

import java.time.YearMonth;
import java.util.List;
import java.util.Optional;

public interface PayrollPersistencePort {
    PayrollDTO save (Payroll payroll);
    Optional<Payroll> finById (Long id);
    List<Payroll> findByEmpleadoId(long id);
    List<Payroll> findPeriodId (YearMonth period);
    List<Payroll> findAll ();
    List<Payroll> findByEstate (PayrollState estado);

}
