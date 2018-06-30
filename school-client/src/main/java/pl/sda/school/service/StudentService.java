package pl.sda.school.service;

import org.springframework.stereotype.Service;
import pl.sda.model.Student;
import pl.sda.school.iservice.IStudentService;

@Service
public class StudentService implements IStudentService {

    @Override
    public void save(Student student) {
        //todo add Student to repository
    }

}
