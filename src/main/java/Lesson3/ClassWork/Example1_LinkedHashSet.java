package Lesson3.ClassWork;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by Student on 18.07.2016.
 */
public class Example1_LinkedHashSet {
    public static void main(String[] args) {
        Set<Person> persona = new LinkedHashSet<>();
        PersonFirstLoad.init(persona);
        PersonFirstLoad.print(persona);

        System.out.println("size = " + persona.size());
    }
}
