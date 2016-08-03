package Lesson1.HomeWork.first;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by user on 13.07.16.
 */
public class Task2023 {
    public static void main(String[] args) {
        File file = new File("Lesson1/HomeWork/texts/input_2023.txt");
        if(!file.exists()){
            System.out.println("Cannot open file");
            System.exit(1);
        }

        try(Scanner input = new Scanner(file)){
            int count = 0;
            int index = 0;
            int [][] array = new int[2][];
            while(input.hasNext()){
                String line = input.nextLine();
                if(count == 0) {
                    count = Integer.parseInt(line);
                    if(count<1 && count>10000)
                        break;
                }
                else {
                    array[index++] = Task2021.getInteger(line.split(" "));
                    count = 0;
                }
            }
            if(array[0]!=null && array[1]!=null) {
                PrintWriter output = new java.io.PrintWriter("Lesson1/HomeWork/texts/output_2023.txt");
                Arrays.sort(array[0]);
                Arrays.sort(array[1]);
                int amount = 0;
                String result = "";
                for (int i = 0; i < array[0].length ; i++) {
                    for (int j = 0; j < array[1].length; j++) {
                        if(array[0][i]==array[1][j]){
                            ++amount;
                            result+=array[0][i]+" ";
                            break;
                        }
                    }
                }
                output.println(amount);
                output.println(result);
                output.close();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Exception: Cannot open file");
        }
    }
}
