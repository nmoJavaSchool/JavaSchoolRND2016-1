package first;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Created by user on 13.07.16.
 */
public class Task2011 {
    public static void main(String[] args) {
        File file = new File("texts/input_2011.txt");
        if(!file.exists()){
            System.out.println("Cannot open file");
            System.exit(1);
        }

        try(Scanner input = new Scanner(file)){
            String result = "";
            while(input.hasNext()){
                String line = input.next();
                try {
                    int number = Integer.parseInt(line);
                    if(number>=1 && number <=150){
                        if(number<7){
                            result = "preschool child";
                        }else if(number>=7 && number<=17){
                            result = "scholchild "+(number-7+1);
                        }else if(number>=18 && number<=22){
                            result = "student "+(number-18+1);
                        }else{
                            result = "specialist";
                        }
                    }

                }catch (NumberFormatException ne){

                }
                break;
            }

            try (PrintWriter output = new java.io.PrintWriter("texts/output_2011.txt")) {
                output.println(result);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Exception: Cannot open file");
        }
    }
}
