package first;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Created by user on 12.07.16.
 */
public class Task2002 {
    public static void main(String[] args) {
        File file = new File("texts/input_2002.txt");
        if(!file.exists()){
            System.out.println("Cannot open file");
            System.exit(1);
        }

        try(Scanner input = new Scanner(file)){
            int sum = 0;
            int count = 0;
            while(input.hasNext()){
                String line = input.next();
                try {
                    if(count == 0)
                        count = Integer.parseInt(line);
                    else {
                        --count;
                        int number = Integer.parseInt(line);
                        if (number >= 1 && number <= 1000)
                            sum += number;

                        if(count ==0) break;
                    }
                }catch (NumberFormatException ne){

                }
            }

            try (PrintWriter output = new java.io.PrintWriter("texts/output_2002.txt")) {
                output.println(sum);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Exception: Cannot open file");
        }
    }
}
