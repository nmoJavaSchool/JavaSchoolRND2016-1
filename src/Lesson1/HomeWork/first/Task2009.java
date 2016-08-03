package Lesson1.HomeWork.first;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Created by user on 13.07.16.
 */
public class Task2009 {
    public static void main(String[] args) {
        File file = new File("Lesson1/HomeWork/texts/input_2009.txt");
        if(!file.exists()){
            System.out.println("Cannot open file");
            System.exit(1);
        }

        try(Scanner input = new Scanner(file)){
            int sum = 0;
            int count = 0;
            int index = 1;
            while(input.hasNext()){
                String line = input.next();
                try {
                    if(count == 0)
                        count = Integer.parseInt(line);
                    else {
                        --count;
                        int number = Integer.parseInt(line);
                        if (number >= 1 && number <= 1000) {
                            if(index%2 == 0 || index==1)
                                sum+=number;
                        }
                        ++index;
                        if(count ==0) break;
                    }
                }catch (NumberFormatException ne){

                }
            }

            try (PrintWriter output = new java.io.PrintWriter("Lesson1/HomeWork/texts/output_2009.txt")) {
                output.println(sum);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Exception: Cannot open file");
        }
    }
}
