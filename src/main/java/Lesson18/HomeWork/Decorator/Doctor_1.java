package Lesson18.HomeWork.Decorator;

/**
 * Created by user on 12.09.16.
 */
public class Doctor_1 extends Doctor {


    public void doHealthCare() {
        System.out.println("\n********************************");
        System.out.println("The doctor is the patient home");
        super.doHealthCare();
        System.out.println("The doctor provides first aid.");
    }
}
