package pl.sda.school;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StudentGradesController implements IStudentGrades {
    @GetMapping("/grades/list")
    public String studentsGradeListView(Model model) {
        model.addAttribute("grades", gradesService.findAll);
        return "studentGradeList";
    }

}
