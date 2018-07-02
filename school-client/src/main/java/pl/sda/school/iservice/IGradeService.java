package pl.sda.school.iservice;

import pl.sda.model.Grade;

import java.util.List;

public interface IGradeService {
    List<Grade> findAll();

    void save(Grade grade);
}
