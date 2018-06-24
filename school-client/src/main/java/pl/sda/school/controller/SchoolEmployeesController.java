package pl.sda.school.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.sda.school.service.IEmployeeService;

@Controller
public class SchoolEmployeesController {

    private IEmployeeService employeeService;

    @Autowired
    public SchoolEmployeesController(IEmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @RequestMapping("employees/list")
    public String listStudentsGradesView(Model model){
        model.addAttribute("employees", employeeService.findAll());
        System.out.println("employees list");
        return "employeesList";
    }
}
