package Lesson3.ClassWork;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Student on 18.07.2016.
 */
public class Exaample1_ArrayList {
    public static void main(String[] args) {
        List<Person> persons = new ArrayList<>();
        PersonFirstLoad.init(persons);
        //System.out.println(persons);
        PersonFirstLoad.print(persons);
    }

}
