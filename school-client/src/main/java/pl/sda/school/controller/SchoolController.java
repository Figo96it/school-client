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
import pl.sda.model.School;
import pl.sda.school.service.SchoolService;

import static org.slf4j.LoggerFactory.getLogger;

@Controller
public class SchoolController {

    private static final Logger logger = getLogger(AppController.class);
    private SchoolService schoolService;

    @Autowired
    public SchoolController(SchoolService schoolService) {
        this.schoolService = schoolService;
    }

    @RequestMapping("school/list")
    public String listSchoolView(Model model) {
        logger.debug("View school list");
        model.addAttribute("schools", schoolService.findAll());
        return "schoolsList";
    }

    @PostMapping("school/create")
    public String addSchool(@ModelAttribute School school) {
        schoolService.save(school);
        return "redirect:/";
    }

    @GetMapping("school/create")
    public String addSchoolView(Model model) {
        logger.debug("create school");
        model.addAttribute("school", new School());
        return "createSchool";
    }
}
