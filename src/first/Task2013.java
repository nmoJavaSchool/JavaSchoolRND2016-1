package first;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Created by user on 13.07.16.
 */
public class Task2013 {
    public static void main(String[] args) {
        File file = new File("texts/input_2013.txt");
        if(!file.exists()){
            System.out.println("Cannot open file");
            System.exit(1);
        }

        try(Scanner input = new Scanner(file)){
            int min = 0;
            int count = 0;
            int amountOfMin = 0;
            boolean flag = true;
            while(input.hasNext()){
                String line = input.next();
                try {
                    if(count == 0) {
                        count = Integer.parseInt(line);
                        if(count<1 || count>10000)
                            break;
                    }
                    else {
                        --count;
                        int number = Integer.parseInt(line);

                        if (number >= -1000 && number <= 1000) {

                            if(flag){
                                min = number;
                                ++amountOfMin;
                                flag = false;
                            }else{

                                if(min>number){
                                    min = number;
                                    amountOfMin=1;
                                }else if(min ==number){
                                    ++amountOfMin;
                                }
                            }
                        }
                        if(count ==0) break;
                    }
                }catch (NumberFormatException ne){
                    break;
                }
            }

            try (PrintWriter output = new java.io.PrintWriter("texts/output_2013.txt")) {
                output.println(amountOfMin);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Exception: Cannot open file");
        }
    }
}
