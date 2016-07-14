package first;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Created by user on 13.07.16.
 */
public class Task2022 {
    public static void main(String[] args) {
        File file = new File("texts/input_2022.txt");
        if(!file.exists()){
            System.out.println("Cannot open file");
            System.exit(1);
        }

        try(Scanner input = new Scanner(file)){
            int count = 0;
            while(input.hasNext()){
                String line = input.nextLine();
                try {
                    if(count == 0)
                        count = Integer.parseInt(line);
                    else {
                        int []numbers = Task2021.getInteger(line.split(" "));
                        if(numbers!=null && numbers.length>0) {
                            int maxIndex = 0;

                            if(count>numbers.length)
                                maxIndex = numbers.length;
                            else
                                maxIndex = count;



                            PrintWriter output = new java.io.PrintWriter("texts/output_2022.txt");

                            int amount = 0;
                            for (int j = 0; j <maxIndex ; j++) {
                                for (int i = 0; i <maxIndex ; i++) {
                                    if(j!=i && numbers[i]%numbers[j]==0){
                                        ++amount;
                                    }

                                }
                            }

                            output.print(amount);
                            output.close();
                        }
                        break;
                    }
                }catch (NumberFormatException ne){

                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Exception: Cannot open file");
        }
    }

}
