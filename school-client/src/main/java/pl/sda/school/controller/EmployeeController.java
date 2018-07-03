package pl.sda.school.controller;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.sda.AppController;
import pl.sda.model.Employee;
import pl.sda.school.service.EmployeeService;

import static org.slf4j.LoggerFactory.getLogger;


@Controller
public class EmployeeController {

    private static final Logger logger = getLogger(AppController.class);
    private EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @RequestMapping("employee/list")
    public String listEmployeesView(Model model) {
        logger.debug("View employees list");
        model.addAttribute("employees", employeeService.findAll());
        return "employeesList";
    }

    @GetMapping("employee/list/id/{id}")
    public String findEmployeeById(Model model, @PathVariable String id) {
        logger.debug("Find employee by id");
        model.addAttribute("employee", employeeService.findEmployeeById(Integer.valueOf(id)));
        logger.info(String.valueOf(employeeService.findEmployeeById(Integer.valueOf(id))));
        return "employeePersonalData";
    }

    @GetMapping("employee/list/name/{firstName}")
    public String findEmployeesByFirstName(Model model, @PathVariable String firstName) {
        logger.debug("Find employee by first name");
        model.addAttribute("employees", employeeService.findEmployeesByFirstName(firstName));
        logger.info(String.valueOf(employeeService.findEmployeesByFirstName(firstName)));
        return "employeesList";
    }

    @GetMapping("employee/list/surname/{lastName}")
    public String findEmployeesByLastName(Model model, @PathVariable String lastName) {
        logger.debug("Find employee by Last Name");
        model.addAttribute("employees", employeeService.findEmployeesByLastName(lastName));
        logger.info(String.valueOf(employeeService.findEmployeesByLastName(lastName)));
        return "employeesList";
    }

    @PostMapping("employee/add")
    public String addEmployee(@ModelAttribute Employee employee) {
        employeeService.save(employee);
        return "redirect:/";
    }

    @GetMapping("employee/add")
    public String addEmployeeView(Model model) {
        logger.debug("Add employee");
        model.addAttribute("employee", new Employee());
        return "addEmployee";
    }
}
