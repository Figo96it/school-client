package pl.sda.school.service;

import org.springframework.stereotype.Service;
import pl.sda.model.Employee;
import pl.sda.school.iservice.IEmployeeService;

@Service
public class EmployeeService implements IEmployeeService {
    @Override
    public void save(Employee employee) {
        //todo add Employee to repository
    }
}
