package Lesson1.HomeWork.first;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Created by user on 13.07.16.
 */
public class Task2024 {
    public static void main(String[] args) {
        File file = new File("Lesson1/HomeWork/texts/input_2024.txt");
        if(!file.exists()){
            System.out.println("Cannot open file");
            System.exit(1);
        }

        try(Scanner input = new Scanner(file)){
            int count = 0;
            int amount = 0;
            while(input.hasNext()){
                String line = input.nextLine();
                try {
                    if(count == 0)
                        count = Integer.parseInt(line);
                    else {
                        int []numbers = Task2020.getInteger(line.split(" "));
                        if(numbers!=null && numbers.length>0) {
                            for (int i = 0; i < numbers.length/2; i++) {
                                if(numbers[i]!=numbers[numbers.length-1-i])
                                    ++amount;
                            }
                        }
                        break;
                    }
                }catch (NumberFormatException ne){

                }
            }

            PrintWriter output = new java.io.PrintWriter("Lesson1/HomeWork/texts/output_2024.txt");
            output.println(amount);
            output.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Exception: Cannot open file");
        }
    }
}
