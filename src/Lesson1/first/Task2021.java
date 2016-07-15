package Lesson1.first;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Created by user on 13.07.16.
 */
public class Task2021 {
    public static void main(String[] args) {
        File file = new File("Lesson1/texts/input_2021.txt");
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
                        int []numbers = getInteger(line.split(" "));
                        if(numbers!=null && numbers.length>0) {
                            int maxIndex = 0;

                            if(count>numbers.length)
                                maxIndex = numbers.length;
                            else
                                maxIndex = count;



                            PrintWriter output = new java.io.PrintWriter("Lesson1/texts/output_2021.txt");
                            for (int j = 0; j <2 ; j++) {
                                for (int i = 0; i <maxIndex ; i++) {
                                    if(numbers[i]>2)
                                        numbers[i]=numbers[i]/2;

                                }
                            }
                            for (int i = 0; i <maxIndex ; i++) {
                                output.print(numbers[i]+" ");

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
    public static int[] getInteger(String [] arr){
        int [] numbers = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            numbers[i] = Integer.parseInt(arr[i]);
            if(numbers[i]<1 || numbers[i]>100) {
                numbers = null;
                break;
            }
        }
        return numbers;
    }
}
