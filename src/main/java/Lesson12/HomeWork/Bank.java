package Lesson12.HomeWork;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by user on 20.08.16.
 */
public class Bank extends Thread {
    private Integer deposit;
    private int counterOfThread;
    private int constDepost;

    public Bank(int deposit, int counterOfThread) {
        this.deposit = deposit;
        this.counterOfThread = counterOfThread;
        constDepost = deposit;
    }

    @Override
    public void run() {
        ExecutorService executor = Executors.newCachedThreadPool();

        for (int i = 0; i < counterOfThread; i++) {
            Operation operation = new Operation(String.valueOf(i));
            executor.execute(operation);
        }
        executor.shutdown();

    }

    class Operation extends Thread {
        String numberOfOperation;

        public Operation(String nameOfOperation) {
            super(nameOfOperation);
            this.numberOfOperation = nameOfOperation;
        }

        @Override
        public void run() {
            while (deposit != 0) {
                synchronized (deposit) {

                    if(deposit<=0 )break;

                    int cashOperation = 0;
                    do {
                         cashOperation = new Random().nextInt(100) + 1; // 1..100

                    } while (cashOperation > deposit && deposit>0);

                    if(deposit>0 ) {
                        System.out.println("Bank has $" + deposit + " *** Operation " +
                                numberOfOperation + ": = " + "-$" + cashOperation);

                        deposit -= cashOperation;
                    }
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }

            }

        }
    }
}
