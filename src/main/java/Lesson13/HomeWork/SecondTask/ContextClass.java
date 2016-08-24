package Lesson13.HomeWork.SecondTask;

/**
 * Created by user on 24.08.16.
 */
public class ContextClass implements Context {
    private boolean finished;
    private int completedTaskCount;
    private int failedTaskCount;
    private int interruptedTaskCount;

    public ContextClass(boolean finished, int completedTaskCount, int failedTaskCount, int interruptedTaskCount) {
        this.finished = finished;
        this.completedTaskCount = completedTaskCount;
        this.failedTaskCount = failedTaskCount;
        this.interruptedTaskCount = interruptedTaskCount;
    }

    @Override
    public int getCompletedTaskCount() {
        return completedTaskCount;
    }

    @Override
    public int getFailedTaskCount() {
        return failedTaskCount;
    }

    @Override
    public int getInterruptedTaskCount() {
        return interruptedTaskCount;
    }

    @Override
    public void interrupt() {
     throw new UnsupportedOperationException("Unsupported Operation");
    }

    @Override
    public boolean isFinished() {
        return finished;
    }


}
