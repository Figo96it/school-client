package pl.sda.school.controller;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
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

    @GetMapping("parent/list/id/{id}")
    public String findParentById(Model model, @PathVariable String id) {
        logger.debug("Find parent by Id");
        model.addAttribute("parent", parentService.findParentById(Integer.valueOf(id)));
        logger.info(String.valueOf(parentService.findParentById(Integer.valueOf(id))));
        return "parentPersonalData";
    }

    @GetMapping("parent/list/name/{firstName}")
    public String findParentsByFirstName(Model model, @PathVariable String firstName) {
        logger.debug("Find parent by FirstName");
        model.addAttribute("parents", parentService.findParentsByFirstName(firstName));
        logger.info(String.valueOf(parentService.findParentsByFirstName(firstName)));
        return "parentsList";
    }

    @GetMapping("parent/list/surname/{surname}")
    public String findParentsByLastName(Model model, @PathVariable String surname) {
        logger.debug("Find parent by LastName");
        model.addAttribute("parents", parentService.findParentsByLastName(surname));
        logger.info(String.valueOf(parentService.findParentsByLastName(surname)));
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
