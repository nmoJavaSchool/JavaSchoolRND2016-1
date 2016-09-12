package Lesson18.HomeWork.Decorator;

/**
 * Created by user on 12.09.16.
 */
public class DecoratorApp {
    public static void main(String[] args) {
        Person person = new Person();
        person.doHealthCare();

        Doctor_1 doctor_1 = new Doctor_1();
        doctor_1.setSickPerson(person);
        doctor_1.doHealthCare();

        Doctor_2 doctor_2 = new Doctor_2();
        doctor_2.setSickPerson(person);
        doctor_2.doHealthCare();
    }
}
