package pl.sda.school.iservice;


import pl.sda.model.Classroom;
import pl.sda.model.Employee;
import pl.sda.model.School;
import pl.sda.model.Student;

import java.util.ArrayList;
import java.util.List;

public interface IClassService {
    List<Classroom> findAll();
    void save(Classroom Classroom);
}
