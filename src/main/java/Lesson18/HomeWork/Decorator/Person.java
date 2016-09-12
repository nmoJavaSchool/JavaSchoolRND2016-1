package Lesson18.HomeWork.Decorator;

/**
 * Created by user on 12.09.16.
 */
public class Person implements ISickCondition {
    @Override
    public void doHealthCare() {
        System.out.println("Home health care.");
    }
}
