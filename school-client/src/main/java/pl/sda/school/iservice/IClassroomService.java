package pl.sda.school.iservice;


import pl.sda.model.Classroom;

import java.util.List;

public interface IClassroomService {
    List<Classroom> findAll();

    void save(Classroom Classroom);

    Classroom findClassroomById(Integer id);

    Classroom findClassroomsByClassroomName(String className);
}
