package Lesson1.HomeWork.first;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Created by user on 12.07.16.
 */
public class Task2004 {
    public static void main(String[] args) {
        File file = new File("Lesson1/HomeWork/texts/input_2004.txt");
        if(!file.exists()){
            System.out.println("Cannot open file");
            System.exit(1);
        }

        try(Scanner input = new Scanner(file)){
            int leaYear = 0; //
            while(input.hasNext()){
                String line = input.next();
                try {
                    int year = Integer.parseInt(line);
                    if(year>=1000 && year <=2100){
                        if((year%4 ==0 && year%100!=0) || (year % 400 ==0))
                            leaYear=1;
                    }
                }catch (NumberFormatException ne){
                }
                finally {
                    break;
                }
            }

            try (PrintWriter output = new java.io.PrintWriter("Lesson1/HomeWork/texts/output_2004.txt")) {
                output.println(leaYear);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Exception: Cannot open file");
        }
    }
}
