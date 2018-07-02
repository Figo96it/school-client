package pl.sda.school.service;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import pl.sda.AppController;
import pl.sda.model.Plan;
import pl.sda.school.iservice.IPlanService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.slf4j.LoggerFactory.getLogger;

@Service
public class PlanService implements IPlanService {

    private static final Logger logger = getLogger(AppController.class);
    private RestTemplate restTemplate;

    @Value("${school.server.address}")
    private String address;

    @Value("${school.server.port}")
    private String port;

    @Autowired
    public PlanService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public List<Plan> findAll() {
        List<Plan> planList = new ArrayList<>();
        String PLAN_URL = address + port + "/plan/findAll";

        try {
            logger.debug(PLAN_URL);
            ResponseEntity<Plan[]> plans = restTemplate.getForEntity(PLAN_URL, Plan[].class);
            logger.info(plans.toString());
            if (plans.getBody() != null && plans.getBody().length != 0) {
                Plan[] plan = plans.getBody();
                Collections.addAll(planList, plan);
            }
            return planList;
        } catch (HttpClientErrorException e) {
            logger.error(String.valueOf(e));
        }
        return planList;
    }

    @Override
    public void save(Plan plan) {
        //todo add Plan to repository
    }
}
