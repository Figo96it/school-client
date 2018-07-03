package pl.sda.school.service;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import pl.sda.AppController;
import pl.sda.model.Student;
import pl.sda.school.iservice.IStudentService;

import java.util.*;

import static org.slf4j.LoggerFactory.getLogger;

@Service
public class StudentService implements IStudentService {

    private static final Logger logger = getLogger(AppController.class);
    private RestTemplate restTemplate;

    @Value("${school.server.port}")
    private String port;

    @Value("${school.server.address}")
    private String address;


    @Autowired
    public StudentService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public List<Student> findAll() {
        List<Student> studentList = new ArrayList<>();
        String STUDENT_URL = address + port + "/student/findAll";

        try {
            logger.debug(STUDENT_URL);
            ResponseEntity<Student[]> students = restTemplate.getForEntity(STUDENT_URL, Student[].class);
            logger.info(students.toString());
            if (students.getBody() != null && students.getBody().length != 0) {
                Student[] student = students.getBody();
                Collections.addAll(studentList, student);
            }
            return studentList;
        } catch (HttpClientErrorException e) {
            logger.error(String.valueOf(e));
        }
        return studentList;
    }

    @Override
    public Student findStudentById(Integer studentId) {
        Student student = new Student();
        Map<String, String> params = new HashMap<>();
        String STUDENT_BY_ID_URL = address + port + "/student/find/id/{studentId}";
        params.put("studentId", studentId.toString());

        try {
            logger.debug(STUDENT_BY_ID_URL);
            student = restTemplate.getForObject(STUDENT_BY_ID_URL, Student.class, params);
            logger.info(student.toString());
            return student;
        } catch (HttpClientErrorException e) {
            logger.error(String.valueOf(e));
        }
        return student;
    }

    @Override
    public List<Student> findStudentsByFirstName(String firstName) {
        List<Student> studentList = new ArrayList<>();
        Map<String, String> params = new HashMap<>();
        String STUDENT_BY_FIRST_NAME_URL = address + port + "/student/find/name/{firstName}";
        params.put("firstName", firstName);

        try {
            logger.debug(STUDENT_BY_FIRST_NAME_URL);
            ResponseEntity<Student[]> students = restTemplate.getForEntity(STUDENT_BY_FIRST_NAME_URL, Student[].class, params);
            logger.info(students.toString());
            if (students.getBody() != null && students.getBody().length != 0) {
                Student[] student = students.getBody();
                Collections.addAll(studentList, student);
            }
            return studentList;
        } catch (HttpClientErrorException e) {
            logger.error(String.valueOf(e));
        }
        return studentList;
    }

    @Override
    public List<Student> findStudentsByLastName(String lastName) {
        List<Student> studentBySurnameList = new ArrayList<>();
        Map<String, String> params = new HashMap<>();
        String STUDENT_BY_LAST_NAME_URL = address + port + "/student/find/surname/{lastName}";
        params.put("lastName", lastName);

        try {
            logger.debug(STUDENT_BY_LAST_NAME_URL);
            ResponseEntity<Student[]> students = restTemplate.getForEntity(STUDENT_BY_LAST_NAME_URL, Student[].class, params);
            logger.info(students.toString());
            if (students.getBody() != null && students.getBody().length != 0) {
                Student[] student = students.getBody();
                Collections.addAll(studentBySurnameList, student);
            }
            return studentBySurnameList;
        } catch (HttpClientErrorException e) {
            logger.error(String.valueOf(e));
        }
        return studentBySurnameList;
    }


    @Override
    public void save(Student student) {
        //todo add Student to repository
    }

}
