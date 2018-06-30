package pl.sda.school.service;

import org.springframework.stereotype.Service;
import pl.sda.model.Parent;
import pl.sda.school.iservice.IParentService;

@Service
public class ParentService implements IParentService {
    @Override
    public void save(Parent parent) {
        //todo add Parent to repository
    }
}
