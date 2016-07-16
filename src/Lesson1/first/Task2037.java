package Lesson1.first;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Created by user on 16.07.16.
 */
public class Task2037 {
    public static void main(String[] args) {
        File file = new File("Lesson1/texts/input_2037.txt");
        if(!file.exists()){
            System.out.println("Cannot open file");
            System.exit(1);
        }

        try(Scanner input = new Scanner(file)){
            int count = 0;
            PrintWriter output = new java.io.PrintWriter("Lesson1/texts/output_2037.txt");
            while(input.hasNext()){
                String line = input.nextLine();
                String [] str = line.split("\\W");
                try {
                    count = Integer.parseInt(input.nextLine());
                }catch (NumberFormatException ne){
                    count = 0;
                }
                if(count>0) {
                    boolean firstFlag = true;
                    for (int i = 0; i < str.length; i++) {
                        if(str[i].length()>=count) {
                            if(firstFlag) {
                                output.print(str[i]);
                                firstFlag = false;
                            }else
                                output.print(", " + str[i]);
                        }
                    }
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
