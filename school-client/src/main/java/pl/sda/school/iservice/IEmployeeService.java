package pl.sda.school.iservice;

import pl.sda.model.Classroom;
import pl.sda.model.Employee;

import java.util.ArrayList;
import java.util.List;

public interface IEmployeeService {
    List<Employee> findAll();
    void save(Employee employee);
}
