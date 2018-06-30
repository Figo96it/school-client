package pl.sda.school.service;

import org.springframework.stereotype.Service;
import pl.sda.model.StudentGrade;
import pl.sda.school.iservice.IStudentGradeService;

@Service
public class StudentGradeService implements IStudentGradeService {
    @Override
    public void save(StudentGrade studentGrade) {
        //todo add StudentGrade to repository
    }
}
