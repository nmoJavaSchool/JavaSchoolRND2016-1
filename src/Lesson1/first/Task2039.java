package Lesson1.first;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Created by user on 17.07.16.
 */
public class Task2039 {
    public static void main(String[] args) {
        File file = new File("Lesson1/texts/input_2039.txt");
        if(!file.exists()){
            System.out.println("Cannot open file");
            System.exit(1);
        }

        try(Scanner input = new Scanner(file)){

            PrintWriter output = new java.io.PrintWriter("Lesson1/texts/output_2039.txt");
            while(input.hasNext()){
                String line = input.nextLine();
                if(line.length()<=1000) {
                    String[] str = line.split("[\\W\\d]");


                    output.print(str.length);
                }
                break;
            }
            output.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Exception: Cannot open file");
        }
    }
}
