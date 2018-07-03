package pl.sda.school.service;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import pl.sda.AppController;
import pl.sda.model.Employee;
import pl.sda.school.iservice.IEmployeeService;

import java.util.*;

import static org.slf4j.LoggerFactory.getLogger;

@Service
public class EmployeeService implements IEmployeeService {

    private static final Logger logger = getLogger(AppController.class);
    private RestTemplate restTemplate;

    @Value("${school.server.address}")
    private String address;

    @Value("${school.server.port}")
    private String port;

    @Autowired
    public EmployeeService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public List<Employee> findAll() {
        List<Employee> employeeList = new ArrayList<>();
        String EMPLOYEE_URL = address + port + "/employee/findAll";

        try {
            logger.debug(EMPLOYEE_URL);
            ResponseEntity<Employee[]> employees = restTemplate.getForEntity(EMPLOYEE_URL, Employee[].class);
            logger.info(employees.toString());
            if (employees.getBody() != null && employees.getBody().length != 0) {
                Employee[] employee = employees.getBody();
                Collections.addAll(employeeList, employee);
            }
            return employeeList;
        } catch (HttpClientErrorException e) {
            logger.error(String.valueOf(e));
        }
        return employeeList;
    }

    @Override
    public Employee findEmployeeById(Integer id) {
        Employee employee = new Employee();
        Map<String, String> params = new HashMap<>();
        String EMPLOYEE_BY_ID_URL = address + port + "/employee/find/id/{id}";
        params.put("id", id.toString());

        try {
            logger.debug(EMPLOYEE_BY_ID_URL);
            employee = restTemplate.getForObject(EMPLOYEE_BY_ID_URL, Employee.class, params);
            logger.info(employee.toString());
            return employee;
        } catch (HttpClientErrorException e) {
            logger.error(String.valueOf(e));
        }
        return employee;
    }

    @Override
    public List<Employee> findEmployeesByFirstName(String firstName) {
        List<Employee> employeeList = new ArrayList<>();
        Map<String, String> params = new HashMap<>();
        String EMPLOYEE_BY_FIRST_NAME_URL = address + port + "/employee/find/name/{firstName}";
        params.put("firstName", firstName);

        try {
            logger.debug(EMPLOYEE_BY_FIRST_NAME_URL);
            ResponseEntity<Employee[]> students = restTemplate.getForEntity(EMPLOYEE_BY_FIRST_NAME_URL, Employee[].class, params);
            logger.info(students.toString());
            if (students.getBody() != null && students.getBody().length != 0) {
                Employee[] employee = students.getBody();
                Collections.addAll(employeeList, employee);
            }
            return employeeList;
        } catch (HttpClientErrorException e) {
            logger.error(String.valueOf(e));
        }
        return employeeList;
    }

    @Override
    public List<Employee> findEmployeesByLastName(String lastName) {
        List<Employee> employeeBySurnameList = new ArrayList<>();
        Map<String, String> params = new HashMap<>();
        String EMPLOYEE_BY_LAST_NAME_URL = address + port + "/employee/find/surname/{lastName}";
        params.put("lastName", lastName);

        try {
            logger.debug(EMPLOYEE_BY_LAST_NAME_URL);
            ResponseEntity<Employee[]> students = restTemplate.getForEntity(EMPLOYEE_BY_LAST_NAME_URL, Employee[].class, params);
            logger.info(students.toString());
            if (students.getBody() != null && students.getBody().length != 0) {
                Employee[] employee = students.getBody();
                Collections.addAll(employeeBySurnameList, employee);
            }
            return employeeBySurnameList;
        } catch (HttpClientErrorException e) {
            logger.error(String.valueOf(e));
        }
        return employeeBySurnameList;
    }

    @Override
    public void save(Employee employee) {
        //todo add Employee to repository
    }
}
