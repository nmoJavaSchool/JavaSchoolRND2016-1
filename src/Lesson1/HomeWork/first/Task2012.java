package Lesson1.HomeWork.first;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Created by user on 13.07.16.
 */
public class Task2012 {
    public static void main(String[] args) {
        File file = new File("Lesson1/HomeWork/texts/input_2012.txt");
        if(!file.exists()){
            System.out.println("Cannot open file");
            System.exit(1);
        }

        try(Scanner input = new Scanner(file)){
            String result = "";
            int [] array = new int[4];
            int i=0;
            while(input.hasNext()){
                String line = input.next();
                try {
                    array[i++] = Integer.parseInt(line);
                    if(i==4)break;

                }catch (NumberFormatException ne){

                }
            }
            if(i==4){
                if((array[0]+array[2]==array[1] && array[1]==array[3])
                        ||(array[0]+array[3]==array[1] && array[1]==array[2])
                        ||(array[1]+array[2]==array[0] && array[0]==array[3])
                        ||(array[1]+array[3]==array[0] && array[0]==array[2])) {
                    result = "YES";
                }
                else{
                    result = "NO";
                }
            }
            
            try (PrintWriter output = new java.io.PrintWriter("Lesson1/HomeWork/texts/output_2012.txt")) {
                output.println(result);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Exception: Cannot open file");
        }
    }
}
