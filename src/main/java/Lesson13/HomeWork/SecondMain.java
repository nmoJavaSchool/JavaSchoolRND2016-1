package Lesson13.HomeWork;

import Lesson13.HomeWork.SecondTask.ContextClass;
import Lesson13.HomeWork.SecondTask.ExecutionImpl;
import Lesson13.HomeWork.SecondTask.ThreadRunnable;

import java.util.Random;

/**
 * Created by user on 24.08.16.
 */
public class SecondMain {
    public static void main(String[] args) {
        final int COUNT = 10;
        ThreadRunnable []array = new ThreadRunnable[COUNT];

        for (int i = 0; i < COUNT; i++) {
            ThreadRunnable thread = new ThreadRunnable("Thread #"+i);
            array[i] = thread;
        }
        Runnable callback = new Runnable() {
            @Override
            public void run() {
                System.out.println("*** Callback thread ***");
            }
        };
        Random random = new Random();
        for (int i = 0; i < COUNT; i++) {
            if(random.nextInt(100)+1 > 80)
                array[i].interrupt();
            if(random.nextInt(100)+1 < 20)
                array[i].fail();
        }

        ExecutionImpl execution = new ExecutionImpl();


        ContextClass contextClass = (ContextClass) execution.execute(callback, array);
        System.out.println("----------------------------------------------------");
        System.out.println("Completed Task = " + contextClass.getCompletedTaskCount());
        System.out.println("Failed Task = " + contextClass.getFailedTaskCount());
        System.out.println("Interrupted Task = " + contextClass.getInterruptedTaskCount());
        System.out.println("Is tasks finished? = " + contextClass.isFinished());

    }
}
