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
import pl.sda.model.Grade;
import pl.sda.school.service.GradeService;

import static org.slf4j.LoggerFactory.getLogger;

@Controller
public class GradeController {

    private static final Logger logger = getLogger(AppController.class);
    private GradeService gradeService;

    @Autowired
    public GradeController(GradeService gradeService) {
        this.gradeService = gradeService;
    }

    @RequestMapping("grade/list")
    public String listGradesView(Model model) {
        logger.debug("View grades list");
        model.addAttribute("grades", gradeService.findAll());
        return "gradesList";
    }

    @PostMapping("grade/add")
    public String addGrade(@ModelAttribute Grade grade) {
        gradeService.save(grade);
        return "redirect:/";
    }

    @GetMapping("grade/add")
    public String addGradesView(Model model) {
        logger.debug("Add grade");
        model.addAttribute("grade", new Grade());
        return "addGrade";
    }
}
