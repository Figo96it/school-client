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
import pl.sda.model.Student;
import pl.sda.school.service.StudentService;

import static org.slf4j.LoggerFactory.getLogger;

@Controller
public class StudentsController {

    private static final Logger logger = getLogger(AppController.class);
    private StudentService studentService;

    @Autowired
    public StudentsController(StudentService studentService) {
        this.studentService = studentService;
    }

    @RequestMapping("student/list")
    public String listStudentsView(Model model) {
        logger.debug("View student list");
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
