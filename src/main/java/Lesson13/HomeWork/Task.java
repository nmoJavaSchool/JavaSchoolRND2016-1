package Lesson13.HomeWork;

import java.util.concurrent.Callable;

/**
 * Created by user on 23.08.16.
 */
public class Task<V> {
    private Callable<? extends V> callable;
    private volatile boolean flag = false;
    public Task(Callable<? extends V> callable) {
        this.callable = callable;
    }

    public Callable<? extends V> getCallable() {
        return callable;
    }

    public synchronized V get() {
        if(flag)
            throw new CallableThreadException("CallableThreadException");

        try {
            return callable.call();
        } catch (Exception e) {
            flag = true;
            throw new CallableThreadException("CallableThreadException");
        }
    }
}
