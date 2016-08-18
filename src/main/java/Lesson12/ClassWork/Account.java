package Lesson12.ClassWork;

/**
 * Created by Student on 18.08.2016.
 */
public class Account implements Runnable{
    private int saldo;

    public Account(int saldo) {
        this.saldo = saldo;
    }

    public void decreaseSaldo(int sum) {
        if (saldo - sum < 0) {
            System.out.println("Overdraft is not available");
        }else{
            saldo -=sum ;
        }
    }

    public int getSaldo() {
        return saldo;
    }

    @Override
    public void run() {

    }
}
