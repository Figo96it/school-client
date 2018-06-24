package pl.sda.school;

import pl.sda.model.Employee;

import java.util.ArrayList;
import java.util.List;

public interface IEmployeeService {
    default List<Employee> findAll(){
        Employee employee=new Employee();
        Employee employee2=new Employee();
        employee.setId((long)3);
        employee.setFirstName("Kamil");
        employee.setLastName("Urbaniak");
        employee.setPosition("Director");
        employee.setClassId((long)4);
        employee2.setId((long)1);
        employee2.setFirstName("Adam");
        employee2.setLastName("Kowalski");
        employee2.setPosition("Teacher");
        employee2.setClassId((long) 1);
        List<Employee> employees=new ArrayList<>();
        employees.add(employee);
        employees.add(employee2);
        return employees;
    }

    default void save(Employee employee){
        //todo dodanie studenta do repozytorium
    }
}
