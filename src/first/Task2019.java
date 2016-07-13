package first;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Created by user on 13.07.16.
 */
public class Task2019 {
    public static void main(String[] args) {
        File file = new File("texts/input_2019.txt");
        if(!file.exists()){
            System.out.println("Cannot open file");
            System.exit(1);
        }

        try(Scanner input = new Scanner(file)){
            int position = 0;
            while(input.hasNext()){
                String line = input.next();
                try {
                    int number = Integer.parseInt(line);
                    if(number>=1 && number <=(int)Math.pow(10,8)){
                        int start = 0;
                        int end;
                        for (int i = 1; true ; i++) {
                            end = i + start;
                            if(number>=start && number<=end){
                                position = i;
                                break;
                            }
                            start = end;
                        }
                    }

                }catch (NumberFormatException ne){

                }
                finally {
                    break;
                }
            }

            try (PrintWriter output = new java.io.PrintWriter("texts/output_2019.txt")) {
                output.println(position);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Exception: Cannot open file");
        }
    }
}
