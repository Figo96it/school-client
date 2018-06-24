package pl.sda.school.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.sda.school.service.IStudentGradeService;

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
}
