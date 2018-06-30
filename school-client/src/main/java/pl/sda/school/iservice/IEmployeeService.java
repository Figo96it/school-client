package pl.sda.school.iservice;

import pl.sda.model.Classroom;
import pl.sda.model.Employee;

import java.util.ArrayList;
import java.util.List;

public interface IEmployeeService {
    default List<Employee> findAll() {
        Employee employee = new Employee();
        employee.setId(3);
        employee.setFirstName("Kamil");
        employee.setLastName("Urbaniak");
        employee.setPosition("Director");
        employee.setClassroom(new Classroom());
        List<Employee> employees = new ArrayList<>();
        employees.add(employee);
        return employees;
    }

    void save(Employee employee);
}
