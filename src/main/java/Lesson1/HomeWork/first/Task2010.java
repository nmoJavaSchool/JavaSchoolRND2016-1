package Lesson1.HomeWork.first;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Created by user on 13.07.16.
 */
public class Task2010 {
    public static void main(String[] args) {
        File file = new File("Lesson1/HomeWork/texts/input_2010.txt");
        if(!file.exists()){
            System.out.println("Cannot open file");
            System.exit(1);
        }

        try(Scanner input = new Scanner(file)){
            String result = "";
            while(input.hasNext()){
                String line = input.nextLine();
                try {
                    String []strNumbers = line.split(" ");
                    if(strNumbers.length==2){
                        long num1 = Long.parseLong(strNumbers[0]);
                        long num2 = Long.parseLong(strNumbers[1]);
                        if(num1>=0 && num1<=(long)Math.pow(10,7) &&
                                num2>=0 && num2<=(long)Math.pow(10,7)) {
                            result = gcd(num2, num1) + "";
                        }
                    }

                }catch (NumberFormatException ne){
                }
                finally {
                    break;
                }
            }

            try (PrintWriter output = new java.io.PrintWriter("Lesson1/HomeWork/texts/output_2010.txt")) {
                output.println(result);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Exception: Cannot open file");
        }
    }
    public static long gcd(long m, long n) {
        if (m % n == 0)
            return n;
        else
            return gcd(n, m % n);
    }
}
