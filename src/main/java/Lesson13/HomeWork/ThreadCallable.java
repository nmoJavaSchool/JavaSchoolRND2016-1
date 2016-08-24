package Lesson13.HomeWork;

import java.util.concurrent.Callable;

/**
 * Created by user on 23.08.16.
 */
public class ThreadCallable<V> implements Callable<V> {
    private V name;

    public ThreadCallable(V name) {
        this.name = name;
    }

    @Override
    public V call() throws Exception {
        return name;
    }
}
