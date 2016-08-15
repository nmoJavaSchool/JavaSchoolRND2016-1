package Lesson11.ClassWork;

import java.util.ArrayList;

/**
 * Created by Student on 15.08.2016.
 */
public class Main {
    public static void main(String[] args) {

        Task1 task1 = new Task1();
        ArrayList<Task1> list = new ArrayList<>();

        for (int i = 0; i < 4; i++) {
            list.add(new Task1());
        }
//        Thread thread = new Thread(task1);
//        thread.start();

        Task2 task2 = new Task2();
        task2.start();

        Runnable runnable = new Runnable() {
            public void run() {
                System.out.println("Runnable");
            }
        };
        Thread thread2 = new Thread(runnable);
        thread2.start();
    }
}
