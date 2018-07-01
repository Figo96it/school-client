package pl.sda.school.iservice;

import pl.sda.model.Student;

import java.util.List;

public interface IStudentService {

    List<Student> findAll();

    void save(Student student);
}
