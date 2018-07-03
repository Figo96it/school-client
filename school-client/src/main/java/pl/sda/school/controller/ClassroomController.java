package pl.sda.school.controller;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.sda.AppController;
import pl.sda.model.Classroom;
import pl.sda.school.service.ClassroomService;

import static org.slf4j.LoggerFactory.getLogger;

@Controller
public class ClassroomController {

    private static final Logger logger = getLogger(AppController.class);
    private ClassroomService classroomService;

    @Autowired
    public ClassroomController(ClassroomService classroomService) {
        this.classroomService = classroomService;
    }

    @RequestMapping("classroom/list")
    public String listClassroomView(Model model) {
        logger.debug("View classrooms list");
        model.addAttribute("classrooms", classroomService.findAll());
        return "classroomsList";
    }

    @GetMapping("classroom/list/id/{id}")
    public String findClassroomById(Model model, @PathVariable String id) {
        logger.debug("Find classroom by id");
        model.addAttribute("classroom", classroomService.findClassroomById(Integer.valueOf(id)));
        logger.info(String.valueOf(classroomService.findClassroomById(Integer.valueOf(id))));
        return "classroomInformation";
    }

    @GetMapping("classroom/list/name/{className}")
    public String findClassroomsByClassroomName(Model model, @PathVariable String className) {
        logger.debug("Find classroom by class name");
        model.addAttribute("classroom", classroomService.findClassroomsByClassroomName(className));
        logger.info(String.valueOf(classroomService.findClassroomsByClassroomName(className)));
        return "classroomInformation";
    }

    @PostMapping("classroom/add")
    public String addClassroom(@ModelAttribute Classroom classroom) {
        classroomService.save(classroom);
        return "redirect:/";
    }

    @GetMapping("classroom/add")
    public String addClassroomView(Model model) {
        logger.debug("Add classroom");
        model.addAttribute("classroom", new Classroom());
        return "addClassroom";
    }
}
