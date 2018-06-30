package pl.sda.school.iservice;

import pl.sda.model.*;

import java.util.ArrayList;
import java.util.List;

public interface IPlanService {

    default List<Plan> findAll() {
        Plan plan = new Plan();
        plan.setClassroom(new Classroom());
        plan.setId(2);
        plan.setSubjects(new ArrayList<>());
        List<Plan> plans = new ArrayList<>();
        plans.add(plan);
        return plans;
    }

    default void save(Plan plan) {
        //todo dodanie planu do repozytorium
    }
}
