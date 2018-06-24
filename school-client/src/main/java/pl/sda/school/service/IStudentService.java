package pl.sda.school.service;

import pl.sda.school.model.Student;

import java.util.ArrayList;
import java.util.List;

public interface IStudentService {

    default List<Student> findAll(){
        Student student=new Student();
        Student student2=new Student();
        student.setFirstName("Marcin");
        student.setId(1);
        student.setLastName("Stus");
        student2.setFirstName("Damian");
        student2.setId(3);
        student2.setLastName("Figinski");
        List<Student> students=new ArrayList<>();
        students.add(student);
        students.add(student2);
        return students;
    }

}
