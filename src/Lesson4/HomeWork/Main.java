package Lesson4.HomeWork;

import java.util.LinkedList;

/**
 * Created by user on 23.07.16.
 */
public class Main {
    public static void main(String[] args) {
        LinkedList<String> list= new LinkedList<>();
        list.add("Russia");
        list.add("the USA");
        list.add(0,"Canada");
        System.out.println(list);
        System.out.println(list.get(2));
        System.out.println(list.remove(0));
        System.out.println(list);
        list.add(0,"China");
        System.out.println(list);
        for (String s: list)
            System.out.print(s.toUpperCase() + " ");
        System.out.println("\n--------------------------");


        MyLinkedList<String> myList = new MyLinkedList<>();
        myList.add("Russia");
        myList.add("the USA");
        myList.add(0,"Canada");
        System.out.println(myList);
        System.out.println(myList.get(2));
        System.out.println(myList.remove(0));
        System.out.println(myList);
        myList.add(0,"China");
        System.out.println(myList);
        for (String s: myList)
            System.out.print(s.toUpperCase() + " ");

    }
}
