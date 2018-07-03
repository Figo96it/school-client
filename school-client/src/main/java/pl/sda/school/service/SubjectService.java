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

import java.util.*;

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

    @Override
    public Subject findSubjectsByNameSubject(String subjectName) {
        Subject subject = new Subject();
        Map<String, String> params = new HashMap<>();
        String SUBJECT_BY_SUBJECT_NAME_URL = address + port + "/subject/find/name/{subjectName}";
        params.put("subjectName", subjectName);

        try {
            logger.debug(SUBJECT_BY_SUBJECT_NAME_URL);
            subject = restTemplate.getForObject(SUBJECT_BY_SUBJECT_NAME_URL, Subject.class, params);
            logger.info(subject.toString());
            return subject;
        } catch (HttpClientErrorException e) {
            logger.error(String.valueOf(e));
        }
        return subject;
    }

    @Override
    public Subject findSubjectById(Integer id) {
        Subject subject = new Subject();
        Map<String, String> params = new HashMap<>();
        String SUBJECT_BY_ID_URL = address + port + "/subject/find/id/{id}";
        params.put("id", id.toString());

        try {
            logger.debug(SUBJECT_BY_ID_URL);
            subject = restTemplate.getForObject(SUBJECT_BY_ID_URL, Subject.class, params);
            logger.info(subject.toString());
            return subject;
        } catch (HttpClientErrorException e) {
            logger.error(String.valueOf(e));
        }
        return subject;
    }
}
