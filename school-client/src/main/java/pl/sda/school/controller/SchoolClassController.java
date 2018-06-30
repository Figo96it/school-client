package pl.sda.school.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.sda.school.iservice.IClassService;

@Controller
public class SchoolClassController {

    private IClassService classService;

    @Autowired
    public SchoolClassController(IClassService classService) {
        this.classService = classService;
    }

    @RequestMapping("classes/list")
    public String listStudentsGradesView(Model model){
        model.addAttribute("classes", classService.findAll());
        return "classesList";
    }
}
