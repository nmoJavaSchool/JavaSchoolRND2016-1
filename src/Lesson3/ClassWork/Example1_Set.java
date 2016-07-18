package Lesson3.ClassWork;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Student on 18.07.2016.
 */
public class Example1_Set {
    public static void main(String[] args) {
        Set<Person> persona = new HashSet<>();
        PersonFirstLoad.init(persona);
        PersonFirstLoad.print(persona);

        System.out.println("size = " + persona.size());
    }
}
