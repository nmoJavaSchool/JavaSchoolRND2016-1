package first;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by user on 13.07.16.
 */
public class Task2020 {
    public static void main(String[] args) {
        File file = new File("texts/input_2020.txt");
        if(!file.exists()){
            System.out.println("Cannot open file");
            System.exit(1);
        }

        try(Scanner input = new Scanner(file)){
            int sum = 0;
            int count = 0;
            int num = 0;
            int amount = 0;
            while(input.hasNext()){
                String line = input.nextLine();
                try {
                    if(count == 0)
                        count = Integer.parseInt(line);
                    else {
                        int []numbers = getInteger(line.split(" "));
                        System.out.println(Arrays.toString(numbers));
                        if(numbers!=null && numbers.length>0) {
                            num = numbers[0];
                            amount = 1;
                            int tempNum = num;
                            int tempAmount = amount;
                            for (int i = 1; i < numbers.length; i++) {
                                if(tempNum == numbers[i]){
                                    ++tempAmount;
                                }else{
                                    if(tempAmount>amount){
                                        amount = tempAmount;
                                        num = tempNum;
                                    }
                                    tempAmount = 1;
                                    tempNum = numbers[i];
                                }
                            }
                        }
                        break;
                    }
                }catch (NumberFormatException ne){

                }
            }

            try (PrintWriter output = new java.io.PrintWriter("texts/output_2020.txt")) {
                output.println(num +"  "+amount);
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
            if(numbers[i]<1 || numbers[i]>10000) {
                numbers = null;
                break;
            }
        }
        return numbers;
    }
}
