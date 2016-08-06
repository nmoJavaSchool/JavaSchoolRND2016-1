package Lesson8.HomeWork;

import java.util.Iterator;

/**
 * Created by user on 06.08.16.
 */
public class Main {
    public static void main(String[] args) {
        MyArrayList<String> arrayList = new MyArrayList<>();
        arrayList.add("Moscow");
        arrayList.add("Rostov-on-Don");
        arrayList.add("Yekaterinburg");

        Iterator<String> city = arrayList.iterator();
        while (city.hasNext()){
            System.out.println(city.next());
        }
    }
}
