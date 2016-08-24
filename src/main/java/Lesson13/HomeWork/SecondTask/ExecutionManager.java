package Lesson13.HomeWork.SecondTask;

/**
 * Created by user on 24.08.16.
 */
public interface ExecutionManager {
    Lesson13.HomeWork.SecondTask.Context execute(Runnable callback, Runnable... tasks);
}
