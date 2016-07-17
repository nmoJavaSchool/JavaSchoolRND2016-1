package Lesson1.first;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by user on 17.07.16.
 */
public class Task2053 {
    public static void main(String[] args) {
        File file = new File("Lesson1/texts/input_2053.txt");
        if(!file.exists()){
            System.out.println("Cannot open file");
            System.exit(1);
        }

        try(Scanner input = new Scanner(file)){
            int index = 0;
            ArrayList<String> list = new ArrayList<>();
            ArrayList<String> code = new ArrayList<>();
            while(input.hasNext()){
                String line = input.next();
                list.add(line);
                if(!code.contains(line)){
                    code.add(line);
                }
            }


            PrintWriter output = new java.io.PrintWriter("Lesson1/texts/output_2053.txt");
            for (int i = 0; i < list.size(); i++) {
                String value = list.get(i);
                if(code.contains(value)){
                    output.print((code.indexOf(value)+1) + " ");
                }
            }
            output.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Exception: Cannot open file");
        }
    }
}
