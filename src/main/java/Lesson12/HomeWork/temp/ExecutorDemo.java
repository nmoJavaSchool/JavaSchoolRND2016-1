package Lesson12.HomeWork.temp;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by user on 22.08.16.
 */
public class ExecutorDemo {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(3);

        executor.execute(new Symbol('a', 100));
        executor.execute(new Symbol('b', 100));
        executor.execute(new Symbol('c', 100));

        executor.shutdown();
    }
    static class Symbol implements Runnable {
        private char sym;
        private int index;

        public Symbol(char c, int t) {
            sym = c;
            index = t;
        }
        @Override
        public void run() {
            for (int i = 0; i < index; i++) {
                System.out.print(sym);
            }
            System.out.println();
        }
    }
}
