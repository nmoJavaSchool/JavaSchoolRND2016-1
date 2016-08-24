package Lesson13.HomeWork;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * Created by user on 23.08.16.
 */
public class Task<V> {
    private FutureTask<? extends V> futureTask;
    private static volatile boolean flag = false;

    public Task(Callable<? extends V> callable) {
        futureTask = new FutureTask<V>((Callable<V>) callable);
    }


    public synchronized V get() throws Exception{
        if(flag)
            throw new CallableThreadException("CallableThreadException");
        futureTask.run();
        V value = futureTask.get();
        if(value==null) {
            flag = true;
            throw new CallableThreadException("CallableThreadException");
        }
        return value;
    }
}
