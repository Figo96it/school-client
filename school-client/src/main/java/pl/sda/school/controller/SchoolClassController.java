package pl.sda.school.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.sda.model.Classroom;
import pl.sda.model.Student;
import pl.sda.school.iservice.IClassService;

@Controller
public class SchoolClassController {

    private IClassService classService;

    @Autowired
    public SchoolClassController(IClassService classService) {
        this.classService = classService;
    }

    @RequestMapping("classes/list")
    public String listStudentsGradesView(Model model) {
        model.addAttribute("classes", classService.findAll());
        return "classesList";
    }

    @PostMapping("classroom/add")
    public String addClassroom(@ModelAttribute Classroom classroom) {
        classService.save(classroom);
        return "redirect:/";
    }

    @GetMapping("classroom/add")
    public String addClassroomView(Model model) {
        model.addAttribute("classroom", new Classroom());
        return "addClass";
    }
}
