package Lesson9.HomeWork;

import java.io.Serializable;

/**
 * Created by user on 10.08.16.
 */
public class Data implements Serializable {
    public String name;
    public String message;

    public Data(String name, String message) {
        this.name = name;
        this.message = message;
    }
}
