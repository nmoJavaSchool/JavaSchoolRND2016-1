package Lesson16.HomeWork;

import java.util.*;

/**
 * Created by user on 04.09.16.
 */
public class Task1 {
    public static void main(String[] args) {
        final int COUNT = 100000;
        Map<Integer, String> map = new HashMap<>(COUNT);
        Random rand = new Random();


        for (int i = 0; i < COUNT; i++) {
            map.put(i, String.valueOf(rand.nextInt()));
        }

        Set<Map.Entry<Integer, String>> entrySet = map.entrySet();

        for (Map.Entry<Integer, String> entry: entrySet)
            sum(entry.getKey(), entry.getValue());
            //System.out.println(entry.getValue() + "\t" + entry.getKey());
    }
    public static String sum(Integer iValue, String strValue){
        return strValue +"  "+ iValue;
    }
}
