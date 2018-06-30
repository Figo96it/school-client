package pl.sda.school.service;

import org.springframework.stereotype.Service;
import pl.sda.model.Plan;
import pl.sda.school.iservice.IPlanService;

@Service
public class PlanService implements IPlanService {
    @Override
    public void save(Plan plan) {
        //todo add Plan to repository
    }
}
