package Lesson1.first;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Created by user on 12.07.16.
 */
public class Task2001 {
    public static void main(String[] args) {
        File file = new File("Lesson1/texts/input_2001.txt");
        if(!file.exists()){
            System.out.println("Cannot open file");
            System.exit(1);
        }

        try(Scanner input = new Scanner(file)){
            int sum = 0;
            while(input.hasNext()){
                String line = input.next();
                try {
                    int number = Integer.parseInt(line);
                    if(number>=1 && number <=1000)
                        sum += number;
                }catch (NumberFormatException ne){

                }
            }

            try (PrintWriter output = new java.io.PrintWriter("Lesson1/texts/output_2001.txt")) {
                output.println(sum);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Exception: Cannot open file");
        }
    }
}
