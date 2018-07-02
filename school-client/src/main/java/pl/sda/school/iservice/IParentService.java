package pl.sda.school.iservice;

import pl.sda.model.Parent;

import java.util.List;

public interface IParentService {
    List<Parent> findAll();

    void save(Parent parent);
}
