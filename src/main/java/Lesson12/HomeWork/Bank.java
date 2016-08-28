package Lesson12.HomeWork;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by user on 20.08.16.
 */
public class Bank extends Thread {
    private AtomicInteger deposit;
    private int counterOfThread;
    private int constDepost;

    public Bank(int deposit, int counterOfThread) {
        this.deposit = new AtomicInteger(deposit);
        this.counterOfThread = counterOfThread;
        constDepost = deposit;
    }

    @Override
    public void run() {
        System.out.println("Bank has $" + deposit);
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
            while (deposit.intValue() != 0) {
                synchronized (deposit) {

                    if(deposit.intValue()<=0 )break;

                    int cashOperation = 0;
                    do {
                         cashOperation = new Random().nextInt(100) + 1; // 1..100

                    } while (cashOperation > deposit.intValue() && deposit.intValue()>0);

                    if(deposit.intValue()>0 ) {
                        System.out.println(deposit+"\t\t*** Operation " + numberOfOperation + ": = " + "-$" + cashOperation);
//                        deposit -= cashOperation;
                        deposit.set(deposit.intValue() -cashOperation);
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
