package pl.sda.school.iservice;

import pl.sda.model.Parent;

import java.util.List;

public interface IParentService {
    List<Parent> findAll();

    Parent findParentById(Integer studentId);

    List<Parent> findParentsByFirstName(String firstName);

    List<Parent> findParentsByLastName(String surname);

    void save(Parent parent);
}
