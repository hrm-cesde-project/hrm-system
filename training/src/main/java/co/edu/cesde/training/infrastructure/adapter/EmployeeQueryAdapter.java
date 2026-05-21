package co.edu.cesde.training.infrastructure.adapter;

import co.edu.cesde.training.application.outputport.EmployeeQueryPort;
import org.springframework.stereotype.Component;

@Component
public class EmployeeQueryAdapter implements EmployeeQueryPort {

    @Override
    public boolean findActiveEmployee(Long employeeId) {

        return true;
    }
}