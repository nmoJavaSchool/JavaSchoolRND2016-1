package first;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Created by user on 13.07.16.
 */
public class Task2016 {
    public static void main(String[] args) {
        File file = new File("texts/input_2016.txt");
        if(!file.exists()){
            System.out.println("Cannot open file");
            System.exit(1);
        }

        try(Scanner input = new Scanner(file)){
            int D;
            while(input.hasNext()){
                String line = input.nextLine();
                try {
                    int[] strNumbers = getInteger(line.split(" "));
                    if(strNumbers!= null && strNumbers.length==3) {
                        int a = strNumbers[0];
                        int b = strNumbers[1];
                        int c = strNumbers[2];
                        D = b*b - 4*a*c;
                        PrintWriter output = new java.io.PrintWriter("texts/output_2016.txt");
                        if(D>0)
                            output.println(2);
                        else if(D<0){
                            output.println("No decision");
                        }else{
                            output.println(1);
                        }
                        output.close();
                    }
                }catch (NumberFormatException ne){
                    break;
                }finally {
                    break;
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
            if(numbers[i]<-100 || numbers[i]>100) {
                numbers = null;
                break;
            }
        }
        return numbers;
    }
}
