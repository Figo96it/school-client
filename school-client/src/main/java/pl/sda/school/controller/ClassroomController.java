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
import pl.sda.model.Classroom;
import pl.sda.school.service.ClassService;

import static org.slf4j.LoggerFactory.getLogger;

@Controller
public class ClassroomController {

    private static final Logger logger = getLogger(AppController.class);
    private ClassService classService;

    @Autowired
    public ClassroomController(ClassService classService) {
        this.classService = classService;
    }

    @RequestMapping("classroom/list")
    public String listClassView(Model model) {
        logger.debug("View classrooms list");
        model.addAttribute("classes", classService.findAll());
        return "classroomsList";
    }

    @PostMapping("classroom/add")
    public String addClassroom(@ModelAttribute Classroom classroom) {
        classService.save(classroom);
        return "redirect:/";
    }

    @GetMapping("classroom/add")
    public String addClassroomView(Model model) {
        logger.debug("Add classroom");
        model.addAttribute("classroom", new Classroom());
        return "addClassroom";
    }
}
