package Lesson12.HomeWork;

import java.util.Random;

/**
 * Created by user on 20.08.16.
 */
public class Bank extends Thread {
    private int deposite;
    private int counterOfThread;

    public Bank(int deposite, int counterOfThread) {
        this.deposite = deposite;
        this.counterOfThread = counterOfThread;
    }

    @Override
    public void run() {
        while (deposite != 0) {
            for (int i = 0; i < counterOfThread; i++) {
                Operation operation = new Operation(String.valueOf(i));
                operation.start();
                try {
                    operation.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    class Operation extends Thread {
        String numberOfOperation;

        public Operation(String nameOfOperation) {
            super(nameOfOperation);
            this.numberOfOperation = nameOfOperation;
        }

        @Override
        public void run() {
            if (deposite != 0) {
                int cashOperation;
                do {
                    cashOperation = new Random().nextInt(100) + 1; // 1..100

                } while (cashOperation > deposite);

                System.out.println("Bank has $" + deposite + " *** Operation " +
                        numberOfOperation + ": = " + (-cashOperation));
//                System.out.println("\t\t\t\t\t(Thread №" + numberOfOperation +
//                        " is finished)");

                deposite -= cashOperation;

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
