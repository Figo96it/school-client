package pl.sda.school.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.sda.model.Plan;
import pl.sda.school.iservice.IPlanService;

@Controller
public class PlanController {


    private IPlanService planService;

    @Autowired
    public PlanController(IPlanService planService) {
        this.planService = planService;
    }

    @RequestMapping("plan/list")
    public String listPlanView(Model model) {
        model.addAttribute("plan", planService.findAll());
        return "planList";
    }

    @PostMapping("plan/add")
    public String addPlan(@ModelAttribute Plan plan) {
        planService.save(plan);
        return "redirect:/";
    }

    @GetMapping("plan/add")
    public String addPlanView(Model model) {
        model.addAttribute("plan", new Plan());
        return "addPlan";
    }
}
