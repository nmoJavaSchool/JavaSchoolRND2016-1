package first;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Created by user on 13.07.16.
 */
public class Task2007 {
    public static void main(String[] args) {
        File file = new File("texts/input_2007.txt");
        if(!file.exists()){
            System.out.println("Cannot open file");
            System.exit(1);
        }

        try(Scanner input = new Scanner(file)){
            int number = 0;
            int count = 0;
            while(input.hasNext()){
                String line = input.next();
                try {
                    number = Integer.parseInt(line);
                    if(number>=1 && number <=(int)Math.pow(10,9)){
                        String bin = Integer.toBinaryString(number);
                        for (int i = bin.length()-1; i >=0 ; i--) {
                            if(bin.charAt(i)=='0')
                                ++count;
                            else
                                break;
                        }
                    }
                }catch (NumberFormatException ne){
                }
                finally {
                    break;
                }
            }

            try (PrintWriter output = new java.io.PrintWriter("texts/output_2007.txt")) {
                output.println(count);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Exception: Cannot open file");
        }
    }
}
