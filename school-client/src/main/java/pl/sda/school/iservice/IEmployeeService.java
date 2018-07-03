package pl.sda.school.iservice;

import pl.sda.model.Employee;

import java.util.List;

public interface IEmployeeService {
    List<Employee> findAll();

    Employee findEmployeeById(Integer id);

    List<Employee> findEmployeesByFirstName(String firstName);

    List<Employee> findEmployeesByLastName(String lastName);

    void save(Employee employee);
}
