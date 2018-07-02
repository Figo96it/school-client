package pl.sda.school.iservice;


import pl.sda.model.Classroom;

import java.util.List;

public interface IClassService {
    List<Classroom> findAll();

    void save(Classroom Classroom);
}
