package Lesson13.HomeWork.SecondTask;

/**
 * Created by user on 24.08.16.
 */
public interface Context {
    int getCompletedTaskCount();
    int getFailedTaskCount();
    int getInterruptedTaskCount();
    void interrupt();
    boolean isFinished();
}
