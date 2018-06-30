package pl.sda.school.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.sda.AppController;
import pl.sda.model.Student;
import pl.sda.school.iservice.IStudentService;

import java.util.List;

@Controller
public class StudentsController {

    private static final Logger logger = LoggerFactory.getLogger(AppController.class);
    private IStudentService studentService;

    @Autowired
    public StudentsController(IStudentService studentService) {
        this.studentService = studentService;
    }

    @RequestMapping("student/list")
    public String listStudentsView(Model model) {
        logger.debug("View students list");
        model.addAttribute("students", studentService.findAll());
        return "studentsList";
    }

    @PostMapping("student/add")
    public String addStudent(@ModelAttribute Student student) {
        studentService.save(student);
        return "redirect:/";
    }

    @GetMapping("student/add")
    public String addStudentView(Model model) {
        logger.debug("Add student");
        model.addAttribute("student", new Student());
        return "addStudent";
    }
}
