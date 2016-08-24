package Lesson13.HomeWork;

import Lesson13.HomeWork.FirstTask.CallableThreadException;
import Lesson13.HomeWork.FirstTask.Task;
import Lesson13.HomeWork.FirstTask.ThreadCallable;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by user on 23.08.16.
 */
public class FirstMain {

    public static void main(String[] args) {

        ExecutorService executor =  Executors.newCachedThreadPool();

        for (int i = 0; i < 10 ; i++) {
            Random random = new Random();
            String nameOfTask = "Task " + random.nextInt(100);
            if(i==5)
                nameOfTask = "";

            TaskThread task = new TaskThread(nameOfTask);
            executor.execute(task);
        }

        executor.shutdown();
    }
    static class TaskThread extends Thread{
        private String name;
        Lock lock = new ReentrantLock();
        private static boolean flag = false;

        public TaskThread(String name) {
            super(name);
            this.name = name;
        }

        @Override
        public void run() {
            lock.lock();
            Task<String> task = new Task<>(new ThreadCallable<String>(name));
            try {
                String value = task.get();
                if(flag)
                    throw new CallableThreadException("CallableThreadException");

                if(value.length()==0) {
                    flag = true;
                    throw new CallableThreadException("CallableThreadException");
                }

                System.out.println(value);
            } catch (Exception e) {
                System.out.println("CallableThreadException");
            }
            lock.unlock();
        }
    }
}
