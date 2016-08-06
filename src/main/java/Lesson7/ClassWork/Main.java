package Lesson7.ClassWork;

import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * Created by Student on 01.08.2016.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println(1);
        try {
            Person person = (Person)Main.class.getClassLoader()
                    .loadClass("Lesson7.ClassWork.Person").newInstance();

            URLClassLoader urlClassLoader =
                    new URLClassLoader(new URL[]{new URL("file:J:\\lecture7\\person")}, null);
//                    new URLClassLoader(new URL[]{new URL("file:J:\\lecture7\\Person")});
//
//            Class<?> persClazz  = urlClassLoader.loadClass("ru.sbertech.test.lesson7.Person");
//            ((Person)persClazz.newInstance()).info();
            person.info();

//            for (int i = 0; i < 10_000_000; i++) {
//                Main.class.getClassLoader()
//                        .loadClass("Lesson7.ClassWork.Person");
//            }
            Class<?> calcClazz = urlClassLoader.loadClass("CalculatorImpl");
            CalculatorImpl calculator = new CalculatorImpl();
            calculator.calc();
        }  catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(2);
    }
}
