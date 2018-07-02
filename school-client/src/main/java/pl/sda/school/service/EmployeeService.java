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

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
    public void save(Employee employee) {
        //todo add Employee to repository
    }
}
