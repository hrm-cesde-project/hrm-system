package co.edu.cesde.contracting.application.inputport;
import co.edu.cesde.contracting.application.dto.employeeActiveDTO;
import co.edu.cesde.contracting.domain.model.Employee;
import co.edu.cesde.contracting.domain.model.Contract;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Comparator;
import java.util.stream.Collectors;

@Service
public class EmployeeQueryService {

    private List<Employee> allEmployees;

    public List<employeeActiveDTO> getAllWithCurrentContract() {
        return allEmployees.stream()
                .map(Employee::toemployeeActiveDTO)
                .collect(Collectors.toList());
    }

    public List<employeeActiveDTO> getActiveEmployees() {
        return allEmployees.stream()
                .filter(Employee::isActive)
                .sorted(Comparator.comparing(Employee::getStartDate).reversed())
                .map(Employee::toemployeeActiveDTO)
                .collect(Collectors.toList());
    }

    public Contract getCurrentContract(Long id) {
        Employee emp = findById(id);
        return emp.getContracts().stream()
                .filter(Contract::isCurrent)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("404 - No tiene contrato vigente"));
    }

    private Employee findById(Long id) {

        return new Employee();
    }
}