package Lesson1.first;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Created by user on 13.07.16.
 */
public class Task2006 {
    public static void main(String[] args) {
        File file = new File("Lesson1/texts/input_2006.txt");
        if(!file.exists()){
            System.out.println("Cannot open file");
            System.exit(1);
        }

        try(Scanner input = new Scanner(file)){
            int number = 0;
            int foot = 0;
            int inch = 0;
            while(input.hasNext()){
                String line = input.next();
                try {
                    number = Integer.parseInt(line);
                    if(number>=1 && number <=1000){
                        number = Math.round(number /3);
                        foot = number/12;
                        inch = number%12;
                    }
                }catch (NumberFormatException ne){
                }
                finally {
                    break;
                }
            }

            try (PrintWriter output = new java.io.PrintWriter("Lesson1/texts/output_2006.txt")) {
                output.println(foot+" "+inch);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Exception: Cannot open file");
        }
    }
}
