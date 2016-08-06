package Lesson1.HomeWork.first;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Created by user on 13.07.16.
 */
public class Task2015 {
    public static void main(String[] args) {
        File file = new File("Lesson1/HomeWork/texts/input_2015.txt");
        if(!file.exists()){
            System.out.println("Cannot open file");
            System.exit(1);
        }

        try(Scanner input = new Scanner(file);PrintWriter output = new java.io.PrintWriter("Lesson1/HomeWork/texts/output_2015.txt") ){
            while(input.hasNext()){
                String line = input.next();
                try {
                    int number = Integer.parseInt(line);
                    if(number>=1 && number <=1000) {
                        for (int i = 2; i <=number ; i++) {
                           if(isPrime(i))
                               output.println(i);
                        }
                    }
                }catch (NumberFormatException ne){

                }
                break;
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Exception: Cannot open file");
        }
    }
    public static boolean isPrime(int number) {
        for (int divisor = 2; divisor <= number / 2; divisor++) {
            if (number % divisor == 0) {
                return false;
            }
        }
        return true;
    }
}
