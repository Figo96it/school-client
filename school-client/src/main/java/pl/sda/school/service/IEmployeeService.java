package pl.sda.school.service;

import pl.sda.school.model.Employee;

import java.util.ArrayList;
import java.util.List;

public interface IEmployeeService {
    default List<Employee> findAll(){
        Employee employee=new Employee();
        Employee employee2=new Employee();
        employee.setId(3);
        employee.setFirstName("Kamil");
        employee.setLastName("Urbaniak");
        employee.setPosition("Director");
        employee.setClassId(4);
        employee2.setId(1);
        employee2.setFirstName("Adam");
        employee2.setLastName("Kowalski");
        employee2.setPosition("Teacher");
        employee2.setClassId(1);
        List<Employee> employees=new ArrayList<>();
        employees.add(employee);
        employees.add(employee2);
        return employees;
    }
}
