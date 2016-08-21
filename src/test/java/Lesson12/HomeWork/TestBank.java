package Lesson12.HomeWork;

import org.junit.Before;
import org.junit.Test;

import java.util.Random;
import static org.junit.Assert.*;

/**
 * Created by user on 21.08.16.
 */
public class TestBank {
    private int deposit;
    private int counterOfThread;
    @Before
    public void setUp() {
        deposit = 1000;
        counterOfThread = 3;
    }

    @Test
    public void testmakeThreads(){
        int temp = deposit;
        while (deposit != 0) {
            for (int i = 0; i < counterOfThread; i++) {
                Operation operation = new Operation(String.valueOf(i));
                operation.start();

                try {
                    operation.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                assertNotEquals(temp,deposit);
                temp = deposit;
            }
        }
        assertEquals(deposit,0);

    }

    class Operation extends Thread {
        String numberOfOperation;

        public Operation(String nameOfOperation) {
            super(nameOfOperation);
            this.numberOfOperation = nameOfOperation;
        }

        @Override
        public void run() {
            if (deposit != 0) {
                int cashOperation;
                do {
                    cashOperation = new Random().nextInt(100) + 1; // 1..100

                } while (cashOperation > deposit);

                deposit -= cashOperation;

            }
        }
    }
}
