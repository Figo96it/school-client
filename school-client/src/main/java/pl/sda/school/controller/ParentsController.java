package pl.sda.school.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.sda.model.Parent;
import pl.sda.school.iservice.IParentService;

import java.util.List;

@Controller
public class ParentsController {

    private IParentService parentService;

    @Autowired
    public ParentsController(IParentService parentsService) {
        this.parentService = parentsService;
    }

    @RequestMapping("parent/list")
    public String listParentsView(Model model) {
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
        model.addAttribute("parent", new Parent());
        return "addParent";
    }

}
