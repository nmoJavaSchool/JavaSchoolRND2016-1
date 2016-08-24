package Lesson13.HomeWork.SecondTask;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by user on 24.08.16.
 */
public class ExecutionImpl implements ExecutionManager {
    @Override
    public Context execute(Runnable callback, Runnable... tasks) {
        int counterOfTasks = tasks.length;

        ExecutorService executor = Executors.newFixedThreadPool(counterOfTasks);
        ArrayList<ThreadRunnable> arrayList = new ArrayList<>();

        for (int i = 0; i < counterOfTasks; i++) {
            ThreadRunnable run = (ThreadRunnable) tasks[i];
            arrayList.add(run);
            executor.execute( tasks[i]);
        }
        executor.shutdown();

        while(!executor.isTerminated()){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println();
        Thread thread = new Thread(callback);
        thread.start();


        boolean isFinished = false;
        int counterOfFinished = 0;
        int completedTaskCount = counterOfTasks;
        int failedTaskCount = 0;
        int interruptedTaskCount = 0;

        for (ThreadRunnable value : arrayList) {
            if(value.isFinished())
                ++counterOfFinished;

            if(value.isFailed())
                ++failedTaskCount;

            if(value.isInterrupted())
                ++interruptedTaskCount;
        }

        if(counterOfFinished == counterOfTasks) {
            isFinished = true;
        }

        completedTaskCount -= failedTaskCount+interruptedTaskCount;

        ContextClass context = new ContextClass(isFinished, completedTaskCount, failedTaskCount, interruptedTaskCount);
        return context;
    }
}
