package pl.sda.school.iservice;

import pl.sda.model.School;

import java.util.List;

public interface ISchoolService {
    List<School> findAll();
    void save(School school);

}
