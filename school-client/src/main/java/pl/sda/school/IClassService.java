package pl.sda.school;


import pl.sda.model.Class;

import java.util.ArrayList;
import java.util.List;

public interface IClassService {
    default List<Class> findAll(){
        Class clas=new Class();
        clas.setClassName("Science");
        clas.setId((long) 2);
        clas.setIdFormTutor((long) 4);
        clas.setIdSchool((long) 12);
        clas.setYear(2001);
        List<Class> classes=new ArrayList<>();
        classes.add(clas);
        return classes;
    }
}
