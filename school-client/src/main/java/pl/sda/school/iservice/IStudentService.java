package pl.sda.school.iservice;

import pl.sda.model.Classroom;
import pl.sda.model.Student;

import java.util.ArrayList;
import java.util.List;

public interface IStudentService {
    default List<Student> findAll() {
        Student student = new Student(1, new Classroom(), "Marcin", "Stus");
        Student student2 = new Student(4, new Classroom(), "Damian", "Figinski");
        List<Student> students = new ArrayList<>();
        students.add(student);
        students.add(student2);
        return students;
    }

    void save(Student student);
}
