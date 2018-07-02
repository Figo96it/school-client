package pl.sda.school.service;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import pl.sda.AppController;
import pl.sda.model.School;
import pl.sda.school.iservice.ISchoolService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.slf4j.LoggerFactory.getLogger;

@Service
public class SchoolService implements ISchoolService {

    private static final Logger logger = getLogger(AppController.class);
    private RestTemplate restTemplate;

    @Value("${school.server.port}")
    private String port;

    @Value("${school.server.address}")
    private String address;

    @Autowired
    public SchoolService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public List<School> findAll() {
        List<School> schoolList = new ArrayList<>();
        String SCHOOL_URL = address + port + "/school/findAll";

        try {
            logger.debug(SCHOOL_URL);
            ResponseEntity<School[]> schools = restTemplate.getForEntity(SCHOOL_URL, School[].class);
            logger.info(schools.toString());
            if (schools.getBody() != null && schools.getBody().length != 0) {
                School[] school = schools.getBody();
                Collections.addAll(schoolList, school);
            }
            return schoolList;
        } catch (HttpClientErrorException e) {
            logger.error(String.valueOf(e));
        }
        return schoolList;
    }

    @Override
    public void save(School school) {

    }
}
