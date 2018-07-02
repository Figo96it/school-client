package pl.sda.school.controller;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.sda.AppController;
import pl.sda.model.Employee;
import pl.sda.school.service.EmployeeService;

import static org.slf4j.LoggerFactory.getLogger;


@Controller
public class EmployeesController {

    private static final Logger logger = getLogger(AppController.class);
    private EmployeeService employeeService;

    @Autowired
    public EmployeesController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @RequestMapping("employee/list")
    public String listEmployeesView(Model model) {
        logger.debug("View employees list");
        model.addAttribute("employees", employeeService.findAll());
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
