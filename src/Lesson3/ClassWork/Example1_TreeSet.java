package Lesson3.ClassWork;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by Student on 18.07.2016.
 */
public class Example1_TreeSet {
    public static void main(String[] args) {
        Set<Person> persona = new TreeSet<>();
        PersonFirstLoad.init(persona);
        PersonFirstLoad.print(persona);

        System.out.println("size = " + persona.size());
    }
}
