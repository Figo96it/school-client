package pl.sda.school.iservice;

import pl.sda.model.Classroom;
import pl.sda.model.Parent;
import pl.sda.model.Student;

import java.util.ArrayList;
import java.util.List;

public interface IParentService {
    List<Parent> findAll();
    void save(Parent parent);
}
