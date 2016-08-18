package Lesson11.ClassWork;

/**
 * Created by Student on 15.08.2016.
 */
public class Task1 implements Runnable{
    public Task1() {
        run();
    }

    @Override
    public void run() {

        for (int i = 0; i < 3; i++) {
            System.out.println(Thread.currentThread().getName() + (i));
        }

    }
}
