package pl.sda.school.service;

import org.springframework.stereotype.Service;
import pl.sda.model.Employee;
import pl.sda.school.iservice.IEmployeeService;

import java.util.List;

@Service
public class EmployeeService implements IEmployeeService {
    @Override
    public List<Employee> findAll() {
        return null;
    }

    @Override
    public void save(Employee employee) {
        //todo add Employee to repository
    }
}
