package pl.sda.school.service;

import org.springframework.stereotype.Service;
import pl.sda.model.Classroom;
import pl.sda.school.iservice.IClassService;

@Service
public class ClassService implements IClassService {
    @Override
    public void save(Classroom Classroom) {
        //todo add Class to repository
    }
}
