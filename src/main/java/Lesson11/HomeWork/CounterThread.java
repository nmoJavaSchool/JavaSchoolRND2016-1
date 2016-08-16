package Lesson11.HomeWork;

import java.util.List;

/**
 * Created by user on 16.08.16.
 */
public class CounterThread extends Thread {
    List<String> list;
    int start;
    int end;
    int sumOfCharacter = 0;

    public CounterThread(List<String> list, int start, int end) {
        this.list = list;
        this.start = start;
        this.end = end;
    }

    @Override
    public void run() {
        for (int i = start; i <= end; i++) {
            String item = list.get(i);
//            for (int j = 0; j < item.length() ; j++) {
//                ++sumOfCharacter;
//            }
            sumOfCharacter += item.length();
        }
//        System.out.println(sumOfCharacter);
    }

    public int getSumOfCharacter() {
        return sumOfCharacter;
    }

}
