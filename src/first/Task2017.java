package first;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Created by user on 13.07.16.
 */
public class Task2017 {
    public static void main(String[] args) {
        File file = new File("texts/input_2017.txt");
        if(!file.exists()){
            System.out.println("Cannot open file");
            System.exit(1);
        }

        try(Scanner input = new Scanner(file)){
            while(input.hasNext()){
                String line = input.nextLine();
                try {
                    int [] numbers = getInteger(line.split(" "));
                    if(numbers!=null && numbers.length==2){
                        int max = 0;
                        String result = "";
                        for (int i = numbers[0]; i <=numbers[1]; i++) {
                            int temp = getAmountOfDivisor(i);
                            if(temp>max){
                                max = temp;
                                result = i+"";
                            }else if(max!=0 && temp ==max){
                                result+=", "+i;
                            }
                        }
                        PrintWriter output = new java.io.PrintWriter("texts/output_2017.txt");
                        output.print(result);
                        output.close();
                    }

                }catch (NumberFormatException ne){

                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Exception: Cannot open file");
        }
    }
    public static int getAmountOfDivisor(int num){
        int count = 0;
        for (int i = 2; i <= num; i++) {
            if(num%i==0)
                ++count;
        }
        return count;
    }
    public static int[] getInteger(String [] arr){
        int [] numbers = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            numbers[i] = Integer.parseInt(arr[i]);
            if(numbers[i]<1 || numbers[i]>5000) {
                numbers = null;
                break;
            }
        }
        return numbers;
    }
}
