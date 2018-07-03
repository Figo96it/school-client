package pl.sda.school.iservice;

import pl.sda.model.Student;

import java.util.List;

public interface IStudentService {

    List<Student> findAll();

    Student findStudentById(Integer studentId);

    List<Student> findStudentsByFirstName(String firstName);

    List<Student> findStudentsByLastName(String lastName);

    void save(Student student);
}
