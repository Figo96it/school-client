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
import pl.sda.model.Subject;
import pl.sda.school.service.SubjectService;

import static org.slf4j.LoggerFactory.getLogger;

@Controller
public class SubjectController {

    private static final Logger logger = getLogger(AppController.class);
    private SubjectService subjectService;

    @Autowired
    public SubjectController(SubjectService subjectService) {
        this.subjectService = subjectService;
    }

    @RequestMapping("subject/list")
    public String listSchoolView(Model model) {
        logger.debug("View subject list");
        model.addAttribute("subjects", subjectService.findAll());
        return "subjectsList";
    }

    @PostMapping("subject/add")
    public String addSubject(@ModelAttribute Subject subject) {
        subjectService.save(subject);
        return "redirect:/";
    }

    @GetMapping("subject/add")
    public String addSubjectView(Model model) {
        logger.debug("Add subject");
        model.addAttribute("subject", new Subject());
        return "addSubject";
    }

}
