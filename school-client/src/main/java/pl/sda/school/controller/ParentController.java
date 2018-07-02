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
import pl.sda.model.Parent;
import pl.sda.school.service.ParentService;

import static org.slf4j.LoggerFactory.getLogger;

@Controller
public class ParentController {

    private static final Logger logger = getLogger(AppController.class);
    private ParentService parentService;

    @Autowired
    public ParentController(ParentService parentService) {
        this.parentService = parentService;
    }


    @RequestMapping("parent/list")
    public String listParentsView(Model model) {
        logger.debug("View parents list");
        model.addAttribute("parents", parentService.findAll());
        return "parentsList";
    }

    @PostMapping("parent/add")
    public String addParent(@ModelAttribute Parent parent) {
        parentService.save(parent);
        return "redirect:/";
    }

    @GetMapping("parent/add")
    public String addParentsView(Model model) {
        logger.debug("Add parent");
        model.addAttribute("parent", new Parent());
        return "addParent";
    }

}
