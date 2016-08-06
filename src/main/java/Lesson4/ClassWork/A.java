package Lesson4.ClassWork;

/**
 * Created by Student on 21.07.2016.
 */
public class A<T> {
    T value;

    public A(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }
    public String getType(){
        return value.getClass().getTypeName();
    }
}
