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
import pl.sda.model.Classroom;
import pl.sda.model.Student;
import pl.sda.school.iservice.IClassService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class ClassService implements IClassService {


    @Value("${school.server.address}")
    private String address;

    @Value("${school.server.port}")
    private String port;


    private RestTemplate restTemplate;
    static final Logger logger = LoggerFactory.getLogger(AppController.class);

    @Autowired
    public ClassService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public List<Classroom> findAll() {
        List<Classroom> classroomsList=new ArrayList<>();
        String CLASSROOM_URL=address+port+"/classroom/findAll";
        try{
            logger.debug(CLASSROOM_URL);
            ResponseEntity<Classroom[]> classrooms = restTemplate.getForEntity(CLASSROOM_URL, Classroom[].class);
            logger.info(classrooms.toString());
            if(classrooms.getBody()!=null && classrooms.getBody().length!=0){
                Classroom[] classroom = classrooms.getBody();
                Collections.addAll(classroomsList, classroom);
            }
            return classroomsList;
        }catch(HttpClientErrorException e){
            logger.error(String.valueOf(e));
        }
        return classroomsList;
    }

    @Override
    public void save(Classroom Classroom) {
        //todo add Class to repository
    }
}
