package Lesson3.ClassWork;

import java.util.ArrayList;

/**
 * Created by Student on 18.07.2016.
 */
public class CollectionBeforeGenerics {
    public static void main(String[] args) {
        ArrayList apples = new ArrayList();
        for (int i = 0; i < 3; i++) {
           apples.add(new Apple());
        }

        apples.add(new Orange());

        for (int i = 0; i < 4; i++) {
            ((Apple) apples.get(i)).getId();
        }

    }

}
