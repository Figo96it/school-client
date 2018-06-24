package pl.sda.school.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.sda.school.service.IStudentService;

@Controller
public class SchoolStudentsController {

    private IStudentService studentService;

    @Autowired
    public SchoolStudentsController(IStudentService studentService) {
        this.studentService = studentService;
    }

    @RequestMapping("students/list")
    public String listStudentsView(Model model){
        model.addAttribute("students", studentService.findAll());
        return "studentsList";
    }
}
