package pl.sda.school.service;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import pl.sda.AppController;
import pl.sda.model.StudentGrade;
import pl.sda.school.iservice.IStudentGradeService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.slf4j.LoggerFactory.getLogger;

@Service
public class StudentGradeService implements IStudentGradeService {

    private static final Logger logger = getLogger(AppController.class);
    private RestTemplate restTemplate;

    @Value("${school.server.address}")
    private String address;

    @Value("${school.server.port}")
    private String port;

    @Autowired
    public StudentGradeService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public List<StudentGrade> findAll() {
        List<StudentGrade> studentGradesList = new ArrayList<>();
        String STUDENT_GRADE_URL = address + port + "/plan/findAll";

        try {
            logger.debug(STUDENT_GRADE_URL);
            ResponseEntity<StudentGrade[]> studentGrades = restTemplate.getForEntity(STUDENT_GRADE_URL, StudentGrade[].class);
            logger.info(studentGrades.toString());
            if (studentGrades.getBody() != null && studentGrades.getBody().length != 0) {
                StudentGrade[] studentGrade = studentGrades.getBody();
                Collections.addAll(studentGradesList, studentGrade);
            }
            return studentGradesList;
        } catch (HttpClientErrorException e) {
            logger.error(String.valueOf(e));
        }
        return studentGradesList;
    }

    @Override
    public void save(StudentGrade studentGrade) {
        //todo add StudentGrade to repository
    }
}
