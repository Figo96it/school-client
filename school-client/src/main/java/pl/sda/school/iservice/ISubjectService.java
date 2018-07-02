package pl.sda.school.iservice;

import pl.sda.model.Subject;

import java.util.List;

public interface ISubjectService {
    List<Subject> findAll();

    void save(Subject subject);
}
