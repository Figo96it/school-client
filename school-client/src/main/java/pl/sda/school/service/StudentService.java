package pl.sda.school.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import pl.sda.AppController;
import pl.sda.model.Student;
import pl.sda.school.iservice.IStudentService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class StudentService implements IStudentService {

    @Value("${school.server.port}")
    private String port;

    @Value("${school.server.address}")
    private String address;

    private RestTemplate restTemplate;
    static final Logger logger = LoggerFactory.getLogger(AppController.class);

    @Autowired
    public StudentService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public List<Student> findAll() {
        List<Student> studentList=new ArrayList<>();
        String STUDENT_URL=address+port+"/student/findAll";

        try{
            logger.debug(STUDENT_URL);
            ResponseEntity<Student[]> students = restTemplate.getForEntity(STUDENT_URL, Student[].class);
            logger.info(students.toString());
            if(students.getBody()!=null && students.getBody().length!=0){
                Student[] student = students.getBody();
                Collections.addAll(studentList, student);
            }
            return studentList;
        }catch(HttpClientErrorException e){
            logger.error(String.valueOf(e));
        }
        return studentList;
    }

    @Override
    public void save(Student student) {
        //todo add Student to repository
    }

}
