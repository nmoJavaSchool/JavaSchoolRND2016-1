package Lesson13.HomeWork;


import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.*;

/**
 * Created by user on 23.08.16.
 */
public class FirstMain {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();
        ArrayList<Future<String>> arrayListOfTask = new ArrayList<>();
        for (int i = 0; i < 10 ; i++) {
            Random random = new Random();
            Lesson13.HomeWork.Task<String> task = new Lesson13.HomeWork.Task<>(new ThreadCallable<String>("Task "+random.nextInt(100)));
            arrayListOfTask.add(executor.submit((Callable<String>) task.getCallable()));
        }

        for(Future<String> value : arrayListOfTask){
            try {
                System.out.println(value.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
        executor.shutdown();
    }
}
