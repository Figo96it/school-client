package pl.sda.school.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.sda.model.StudentGrade;
import pl.sda.school.iservice.IStudentGradeService;

import java.util.List;

@Controller
public class SchoolStudentsGradesController {

    private IStudentGradeService studentGradeService;

    @Autowired
    public SchoolStudentsGradesController(IStudentGradeService studentGradeService) {
        this.studentGradeService = studentGradeService;
    }

    @RequestMapping("students/grades/lists")
    public String listStudentsGradesView(Model model){
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
        //todo uzyj studentservic
        model.addAttribute("studentGrade",new StudentGrade());
        return "addStudentGrade";
    }
}
