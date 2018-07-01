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
import pl.sda.model.Plan;
import pl.sda.school.iservice.IPlanService;

import static org.slf4j.LoggerFactory.getLogger;

@Controller
public class PlanController {

    private static final Logger logger = getLogger(AppController.class);

    private IPlanService planService;

    @Autowired
    public PlanController(IPlanService planService) {
        this.planService = planService;
    }

    @RequestMapping("plan/list")
    public String listPlanView(Model model) {
        logger.debug("View plans list");
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
        logger.debug("Add plan");
        model.addAttribute("plan", new Plan());
        return "addPlan";
    }
}
