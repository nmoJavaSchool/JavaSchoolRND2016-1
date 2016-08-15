package Lesson10.HomeWork;

import java.util.stream.Stream;

/**
 * Created by user on 15.08.16.
 */
public class Task {
    public static void main(String[] args) {
        Integer []array = new Integer[]{1, -9, 0, -95, 8, 78, 1,55};
        Stream.of(array).sorted().forEach(System.out::println);
        System.out.println("-------------------------------------");

        Stream.of(array).forEach(System.out::println);
        System.out.println("-------------------------------------");
        char[] copyFrom = {'d', 'e', 'c', 'a', 'f', 'f', 'e',
                'i', 'n', 'a', 't', 'e', 'd'};

        char[] copyTo = java.util.Arrays.copyOfRange(copyFrom, 2, 9);

        System.out.println(new String(copyTo));
    }
}
