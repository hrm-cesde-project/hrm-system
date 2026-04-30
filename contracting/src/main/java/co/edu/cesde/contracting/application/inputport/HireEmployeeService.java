package co.edu.cesde.contracting.application.inputport;

import co.edu.cesde.contracting.application.dto.HireResposiveDTO;
import co.edu.cesde.contracting.domain.model.Employee;
import co.edu.cesde.contracting.domain.model.Contract;
import co.edu.cesde.contracting.domain.enums.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class HireEmployeeService {

    @Transactional
    public HireResposiveDTO.HireResponseDTO execute(HireEmployeeCommand command) {

        Employee employee = new Employee();

        if (command.contractType() == contractType.FIXED_TERM) {
            employee.setStatus(employedStatus.ON_PROBATION);
        } else {
            employee.setStatus(employedStatus.ACTIVE);
        }

        Contract firstContract = new Contract();

        return new HireResposiveDTO.HireResponseDTO(
                1L,
                101L,
                employee.getStatus(),
                contractStatus.VALID
        );
    }
}
