package pl.sda.school.service;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import pl.sda.AppController;
import pl.sda.model.Subject;
import pl.sda.school.iservice.ISubjectService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.slf4j.LoggerFactory.getLogger;

@Service
public class SubjectService implements ISubjectService{

    private static final Logger logger = getLogger(AppController.class);
    private RestTemplate restTemplate;

    @Value("${school.server.port}")
    private String port;

    @Value("${school.server.address}")
    private String address;

    @Autowired
    public SubjectService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public List<Subject> findAll() {
        List<Subject> subjectList = new ArrayList<>();
        String SUBJECT_URL = address + port + "/subject/findAll";

        try {
            logger.debug(SUBJECT_URL);
            ResponseEntity<Subject[]> subjects = restTemplate.getForEntity(SUBJECT_URL, Subject[].class);
            logger.info(subjects.toString());
            if (subjects.getBody() != null && subjects.getBody().length != 0) {
                Subject[] subject = subjects.getBody();
                Collections.addAll(subjectList, subject);
            }
            return subjectList;
        } catch (HttpClientErrorException e) {
            logger.error(String.valueOf(e));
        }
        return subjectList;
    }

    @Override
    public void save(Subject subject) {

    }
}
