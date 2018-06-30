package pl.sda.school.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.sda.model.Employee;
import pl.sda.school.iservice.IEmployeeService;

import java.util.List;

@Controller
public class SchoolEmployeesController {

    private IEmployeeService employeeService;

    @Autowired
    public SchoolEmployeesController(IEmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @RequestMapping("employees/list")
    public String listEmployeesView(Model model) {
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
        model.addAttribute("employee", new Employee());
        return "addEmployee";
    }
}
