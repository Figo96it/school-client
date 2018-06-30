package pl.sda.school.iservice;
import pl.sda.model.Classroom;
import pl.sda.model.Parent;
import pl.sda.model.Student;

import java.util.ArrayList;
import java.util.List;

public interface IParentService {
    default List<Parent> findAll(){
        Parent parent=new Parent();
        parent.setFirstName("Adam");
        parent.setId(3);
        parent.setStudent(new Student(1,new Classroom(),"Marcin","Stus"));
        parent.setSurname("Kowalski");
        parent.setMail("aaa@bbb.com");
        parent.setTellNumber("824571425");
        parent.setMobilePhoneNumber("874541254");
        List<Parent> parents=new ArrayList<>();
        parents.add(parent);
        return parents;
    }

    default void save(Parent parent){
        //todo dodanie studenta do repozytorium
    }
}
