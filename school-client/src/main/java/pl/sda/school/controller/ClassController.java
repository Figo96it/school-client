package pl.sda.school.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.sda.model.Classroom;
import pl.sda.school.iservice.IClassService;

@Controller
public class ClassController {

    private IClassService classService;

    @Autowired
    public ClassController(IClassService classService) {
        this.classService = classService;
    }

    @RequestMapping("classroom/list")
    public String listClassView(Model model) {
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
