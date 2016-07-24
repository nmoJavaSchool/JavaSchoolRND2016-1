package Lesson4.HomeWork;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by user on 24.07.16.
 */
public class Main2 {
    public static void main(String[] args) {
        LinkedList<Number> list= new LinkedList<>();
        list.add(111);
        list.add(222);
        list.add(0,333);
        System.out.println(list);
        System.out.println(list.get(2));
        System.out.println(list.remove(0));
        System.out.println(list);
        list.add(0,444);
        System.out.println(list);
        for (Number s: list)
            System.out.print(s + " ");

        System.out.println();
        List<Integer> array = new ArrayList<>();
        array.add(-8);
        array.add(-9);
        array.add(-7);

        list.addAll(array);
        System.out.println(list);
        System.out.println("\n--------------------------");


        MyLinkedList<Number> myList = new MyLinkedList<>();
        myList.add(111);
        myList.add(222);
        myList.add(0,333);
        System.out.println(myList);
        System.out.println(myList.get(2));
        System.out.println(myList.remove(0));
        System.out.println(myList);
        myList.add(0,444);
        System.out.println(myList);
        for (Number s: myList)
            System.out.print(s + " ");

        System.out.println();
        myList.addAll(array);
        System.out.println(myList);
        myList.copy(array);
        System.out.println(myList);

    }
}
