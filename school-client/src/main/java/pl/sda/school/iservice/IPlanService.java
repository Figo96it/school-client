package pl.sda.school.iservice;

import pl.sda.model.Plan;

import java.util.List;

public interface IPlanService {

    List<Plan> findAll();

    void save(Plan plan);
}
