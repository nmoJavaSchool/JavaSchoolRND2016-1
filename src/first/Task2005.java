package first;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Created by user on 13.07.16.
 */
public class Task2005 {
    public static void main(String[] args) {
        File file = new File("texts/input_2005.txt");
        if(!file.exists()){
            System.out.println("Cannot open file");
            System.exit(1);
        }

        try(Scanner input = new Scanner(file)){
            int count = 0, countIndex =0;
            int index = 0;
            int min= 0;
            boolean flag = true;
            while(input.hasNext()){
                String line = input.next();
                try {
                    if(count == 0) {
                        countIndex = count = Integer.parseInt(line);
                    }
                    else {
                        --count;
                        int number = Integer.parseInt(line);
                        if (number >= -1000 && number <= 1000) {
                            if(flag){
                                flag = false;
                                min = number;
                            }
                            if(min>number) {
                                min = number;
                                index = countIndex - count;
                            }
                        }

                        if(count ==0) break;
                    }
                }catch (NumberFormatException ne){

                }
            }
            if(index>0) {
                try (PrintWriter output = new java.io.PrintWriter("texts/output_2005.txt")) {
                    output.println(index);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Exception: Cannot open file");
        }
    }
}
