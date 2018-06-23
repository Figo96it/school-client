package pl.sda.school;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SchoolClassController implements ISchoolClass {
    @GetMapping("/class/list")
    public String schoolClassListView(Model model) {
        model.addAttribute("class", classService.findAll);
        return "schoolClassList";
    }
}