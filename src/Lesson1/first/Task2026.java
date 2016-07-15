package Lesson1.first;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Created by user on 14.07.16.
 */
public class Task2026 {
    public static void main(String[] args) {
        File file = new File("Lesson1/texts/input_2026.txt");
        if(!file.exists()){
            System.out.println("Cannot open file");
            System.exit(1);
        }

        try(Scanner input = new Scanner(file)){
            int count = 0;
            while(input.hasNext()){
                String line = input.nextLine();
                try {
                    if(count == 0)
                        count = Integer.parseInt(line);
                    else {
                        int []numbers = Task2020.getInteger(line.split(" "));
                        if(numbers!=null && numbers.length>0) {
                            int maxIndex = 0;

                            if(count>numbers.length)
                                maxIndex = numbers.length;
                            else
                                maxIndex = count;



                            PrintWriter output = new java.io.PrintWriter("Lesson1/texts/output_2026.txt");
                            for (int j = 0; j < numbers.length; j++) {
                                boolean flag = true;
                                for (int i = j; i < numbers.length; i++) {
                                    if (numbers[j] < numbers[i]) {
                                        numbers[j] = numbers[i];
                                        flag = false;
                                        break;
                                    }
                                }
                                if(flag){
                                    numbers[j] = 0;
                                }
                                output.print(numbers[j]+" ");
                            }

                            output.close();
                        }
                        break;
                    }
                }catch (NumberFormatException ne){

                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Exception: Cannot open file");
        }
    }
}
