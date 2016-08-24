package Lesson13.HomeWork.SecondTask;

/**
 * Created by user on 24.08.16.
 */
public class ThreadRunnable implements Runnable {
    private boolean isInterrupted = false;
    private boolean isFinished = true;
    private boolean isFailed = false;
    private String name;

    public ThreadRunnable(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        int count = 1;
        try {
            while (count != 5) {

                if (isInterrupted) {
                    System.out.println("*** "+name+" ***" +" ----- Interrupted");
                    isInterrupted = true;
                    isFinished = false;
                    break;
                }
                if (isFailed) {
                    System.out.println("*** "+name+" ***" +  " ----- Failed");
                    isFailed = true;
                    isFinished = false;
                    break;
                }

                Thread.sleep(1000);
                ++count;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public boolean isInterrupted() {
        return isInterrupted;
    }

    public boolean isFinished() {
        return isFinished;
    }

    public boolean isFailed() {
        return isFailed;
    }

    public void interrupt() {
        isInterrupted = true;
    }
    public void fail() {
        isFailed = true;
    }
}
