package Lesson4.ClassWork;

/**
 * Created by Student on 21.07.2016.
 */
public class B {
    public static <T> String getType(T value){
        return value.getClass().getTypeName();
    }

}
