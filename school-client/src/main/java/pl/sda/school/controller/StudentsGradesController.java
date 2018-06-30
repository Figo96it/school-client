package pl.sda.school.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.sda.AppController;
import pl.sda.model.StudentGrade;
import pl.sda.school.iservice.IStudentGradeService;

import java.util.List;

@Controller
public class StudentsGradesController {

    private static final Logger logger = LoggerFactory.getLogger(AppController.class);
    private IStudentGradeService studentGradeService;

    @Autowired
    public StudentsGradesController(IStudentGradeService studentGradeService) {
        this.studentGradeService = studentGradeService;
    }

    @RequestMapping("student/grade/list")
    public String listStudentsGradesView(Model model) {
        logger.debug("View student grades list");
        model.addAttribute("studentGrades", studentGradeService.findAll());
        return "studentsGradesList";
    }

    @PostMapping("student/grade/add")
    public String addStudentGrade(@ModelAttribute StudentGrade studentGrade) {
        studentGradeService.save(studentGrade);
        return "redirect:/";
    }

    @GetMapping("student/grade/add")
    public String addStudentGradeView(Model model) {
        logger.debug("Add student grade");
        model.addAttribute("studentGrade", new StudentGrade());
        return "addStudentGrade";
    }

}
