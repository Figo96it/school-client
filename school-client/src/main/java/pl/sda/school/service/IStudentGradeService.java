package pl.sda.school.service;

import pl.sda.school.model.StudentGrade;

import java.util.ArrayList;
import java.util.List;

public interface IStudentGradeService {

    default List<StudentGrade> findAll(){
        StudentGrade studentGrade=new StudentGrade();
        studentGrade.setId(4);
        studentGrade.setIdGrade(5);
        studentGrade.setIdStudent(3);
        List<StudentGrade> studentGrades=new ArrayList<>();
        studentGrades.add(studentGrade);
        return studentGrades;
    }
}
