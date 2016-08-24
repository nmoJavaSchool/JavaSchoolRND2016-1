package Lesson13.HomeWork;

import Lesson13.HomeWork.FirstTask.Task;
import Lesson13.HomeWork.FirstTask.ThreadCallable;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by user on 23.08.16.
 */
public class FirstMain {

    public static void main(String[] args) {
        ArrayList<String> arrayListOfTask = new ArrayList<>();

        for (int i = 0; i < 10 ; i++) {
            Random random = new Random();
            String nameOfTask = "Task " + random.nextInt(100);
            if(i==5)
                nameOfTask = null;

            Task<String> task = new Task<>(new ThreadCallable<String>(nameOfTask));

            try {
                arrayListOfTask.add(task.get());
            } catch (Exception e) {
                arrayListOfTask.add("CallableThreadException");
            }
        }

        for(String value : arrayListOfTask){
                System.out.println(value);
        }
    }
}
