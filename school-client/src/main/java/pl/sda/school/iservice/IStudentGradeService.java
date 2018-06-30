package pl.sda.school.iservice;


import pl.sda.model.Classroom;
import pl.sda.model.Grade;
import pl.sda.model.Student;
import pl.sda.model.StudentGrade;

import java.util.ArrayList;
import java.util.List;

public interface IStudentGradeService {

    default List<StudentGrade> findAll(){
        StudentGrade studentGrade=new StudentGrade();
        studentGrade.setId(4);
        studentGrade.setGrade(new Grade());
        studentGrade.setStudent(new Student());
        List<StudentGrade> studentGrades=new ArrayList<>();
        studentGrades.add(studentGrade);
        return studentGrades;
    }

    default void save(StudentGrade studentGrade){
        //todo dodanie oceny do repozytorium
    }
}
