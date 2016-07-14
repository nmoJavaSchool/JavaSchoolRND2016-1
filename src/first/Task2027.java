package first;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Created by user on 14.07.16.
 */
public class Task2027 {
    public static void main(String[] args) {
        File file = new File("texts/input_2027.txt");
        if(!file.exists()){
            System.out.println("Cannot open file");
            System.exit(1);
        }

        int count = 0;
        int index = 0;
        int[] numbers=null;
        int [][] changes= new int[2][];


        try(Scanner input = new Scanner(file)){

            while(input.hasNext()){
                String line = input.nextLine();

                switch (index) {
                    case 0:
                        try {
                            count = Integer.parseInt(line);
                        }catch (NumberFormatException e){

                        }
                        break;
                    case 1:
                        numbers = Task2020.getInteger(line.split(" "));
                        break;
                    case 2:
                        changes[0] = Task2020.getInteger(line.split(" "));
                        break;
                    case 3:
                        changes[1] = Task2020.getInteger(line.split(" "));
                        break;
                }
                index++;
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Exception: Cannot open file");
        }

        if(numbers!=null && changes[1]!=null && changes[0]!=null){
            for (int t = 0; t < 2; t++) {
                int temp = numbers[changes[t][0]-1];
                numbers[changes[t][0]-1] = numbers[changes[t][1]-1];
                numbers[changes[t][1]-1] = temp;
            }
            try {
                PrintWriter output = new PrintWriter("texts/output_2027.txt");
                for (int i = 0; i < numbers.length; i++) {
                    output.print(numbers[i]+" ");
                }
                output.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

        }
    }
}
