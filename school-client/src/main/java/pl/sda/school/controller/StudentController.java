package pl.sda.school.controller;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.sda.AppController;
import pl.sda.model.Student;
import pl.sda.school.service.StudentService;

import static org.slf4j.LoggerFactory.getLogger;

@Controller
public class StudentController {

    private static final Logger logger = getLogger(AppController.class);
    private StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @RequestMapping("student/list")
    public String listStudentsView(Model model) {
        logger.debug("View student list");
        model.addAttribute("students", studentService.findAll());
        return "studentsList";
    }

    @GetMapping("student/list/id/{id}")
    public String findStudentById(Model model, @PathVariable String id) {
        logger.debug("Add student");
        model.addAttribute("student", studentService.findStudentById(Integer.valueOf(id)));
        logger.info(String.valueOf(studentService.findStudentById(Integer.valueOf(id))));
        return "studentPersonalData";
    }

    @GetMapping("student/list/name/{firstName}")
    public String findStudentsByFirstName(Model model, @PathVariable String firstName) {
        logger.debug("Add student");
        model.addAttribute("students", studentService.findStudentsByFirstName(firstName));
        logger.info(String.valueOf(studentService.findStudentsByFirstName(firstName)));
        return "studentsList";
    }

    @GetMapping("student/list/surname/{lastName}")
    public String findStudentsByLastName(Model model, @PathVariable String lastName) {
        logger.debug("Find student by LastName");
        model.addAttribute("students", studentService.findStudentsByLastName(lastName));
        logger.info(String.valueOf(studentService.findStudentsByLastName(lastName)));
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
