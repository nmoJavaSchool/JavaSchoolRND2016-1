package Lesson12.ClassWork;

/**
 * Created by Student on 18.08.2016.
 */
public class Main {
    public static void main(String[] args) {
        final Account account = new Account(100);

        Runnable runnable = new Runnable() {
            public void run() {
                int x = 12;
                for (int i = 0; i < x; i++) {
                    account.decreaseSaldo(10);

                    if (account.getSaldo() < 0) {
                        throw new RuntimeException("Current account is overdrawft");
                    }
                }
            }
        };

        Thread thread = new Thread(runnable);
        thread.start();
    }
}

