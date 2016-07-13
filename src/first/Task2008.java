package first;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by user on 13.07.16.
 */
public class Task2008 {
    public static void main(String[] args) {
        File file = new File("texts/input_2008.txt");
        if(!file.exists()){
            System.out.println("Cannot open file");
            System.exit(1);
        }

        try(Scanner input = new Scanner(file)){
            boolean flag = true;
            int [] trucks = null;
            int [] weights = null;
            int minWeight1 = 0;
            int minWeight2 = 0;
            while(input.hasNext()){
                String line = input.nextLine();
                try {
                    if(flag) {
                        trucks = getInteger(line.split(" "));
                        flag = false;
                    }
                    else
                        weights = getInteger(line.split(" "));

                    if(trucks!=null && weights!=null){
                        System.out.println(Arrays.toString(trucks));
                        System.out.println(Arrays.toString(weights));
                        for (int i = 0; i <trucks.length ; i++) {
                            for (int j = 0; j < weights.length; j++) {
                                if(trucks[i]>weights[j]){
                                    if(weights[j]>minWeight1 && i==0) {
                                        minWeight1 = weights[j];
                                    }

                                    if(weights[j]>minWeight2 && i==1) {
                                        minWeight2 = weights[j];
                                    }

                                }
                            }
                        }
                        break;
                    }
                }catch (NumberFormatException ne){
                }

            }

            try (PrintWriter output = new java.io.PrintWriter("texts/output_2008.txt")) {
                output.println(minWeight1+" "+minWeight2);
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
            if(numbers[i]<1 || numbers[i]>1000) {
                numbers = null;
                break;
            }
        }
        return numbers;
    }
}
