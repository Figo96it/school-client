package pl.sda.school.iservice;


import pl.sda.model.StudentGrade;

import java.util.List;

public interface IStudentGradeService {

    List<StudentGrade> findAll();

    void save(StudentGrade studentGrade);
}
