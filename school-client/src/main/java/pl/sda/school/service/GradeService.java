package pl.sda.school.service;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import pl.sda.AppController;
import pl.sda.model.Grade;
import pl.sda.school.iservice.IGradeService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.slf4j.LoggerFactory.getLogger;

@Service
public class GradeService implements IGradeService {

    private static final Logger logger = getLogger(AppController.class);
    private RestTemplate restTemplate;

    @Value("${school.server.port}")
    private String port;

    @Value("${school.server.address}")
    private String address;

    @Autowired
    public GradeService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public List<Grade> findAll() {
        List<Grade> gradeList = new ArrayList<>();
        String GRADE_URL = address + port + "/grade/findAll";

        try {
            logger.debug(GRADE_URL);
            ResponseEntity<Grade[]> grades = restTemplate.getForEntity(GRADE_URL, Grade[].class);
            logger.info(grades.toString());
            if (grades.getBody() != null && grades.getBody().length != 0) {
                Grade[] grade = grades.getBody();
                Collections.addAll(gradeList, grade);
            }
            return gradeList;
        } catch (HttpClientErrorException e) {
            logger.error(String.valueOf(e));
        }
        return gradeList;
    }

    @Override
    public void save(Grade grade) {

    }
}
