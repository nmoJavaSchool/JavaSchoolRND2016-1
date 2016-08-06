package Lesson1.HomeWork.first;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Created by user on 17.07.16.
 */
public class Task2038 {
    public static void main(String[] args) {
        File file = new File("Lesson1/HomeWork/texts/input_2038.txt");
        if(!file.exists()){
            System.out.println("Cannot open file");
            System.exit(1);
        }

        try(Scanner input = new Scanner(file)){

            PrintWriter output = new java.io.PrintWriter("Lesson1/HomeWork/texts/output_2038.txt");
            while(input.hasNext()){
                String line = input.nextLine();
                if(line.length()<=1000) {
                    String[] str = line.split("[\\W\\d]");
                    String result = "";
                    for (int i = 0; i < str.length; i++) {
                        if (str[i].length() > result.length()) {
                            result = str[i];
                        }
                    }

                    output.print(result + " " + result.length());
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
