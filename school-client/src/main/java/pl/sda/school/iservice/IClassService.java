package pl.sda.school.iservice;


import pl.sda.model.Classroom;
import pl.sda.model.Employee;
import pl.sda.model.School;
import pl.sda.model.Student;

import java.util.ArrayList;
import java.util.List;

public interface IClassService {
    default List<Classroom> findAll() {
        Classroom clas = new Classroom(1, new School(1, "aa", "bb"), "Science", 2012, new Employee());
        List<Classroom> classes = new ArrayList<>();
        classes.add(clas);
        return classes;
    }

    default void save(Classroom Classroom){
        //todo dodanie klasy do repozytorium
    }
}
