package Lesson1.HomeWork.first;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by user on 17.07.16.
 */
public class Task2052 {
    public static void main(String[] args) {
        File file = new File("Lesson1/HomeWork/texts/input_2052.txt");
        if(!file.exists()){
            System.out.println("Cannot open file");
            System.exit(1);
        }

        try(Scanner input = new Scanner(file)){

            int counter = 0;
            int [] nums = null;
            String [] numsForChange = null;
            int [] indices = null;
            while(input.hasNext()){
                String line = input.nextLine();
                if(counter==0){
                    counter = 1;
                    nums = parseToInt(line.split(" "));
                }else if(counter ==1){
                    numsForChange = line.split(" ");
                    ++counter;
                }else if( counter ==2){
                    indices = parseToInt(line.split(" "));
                    break;
                }
            }
            if(nums!=null && numsForChange!= null && indices!=null){
                PrintWriter output = new PrintWriter("Lesson1/HomeWork/texts/output_2052.txt");
                ArrayList<String> newNumbers = getIntegers(numsForChange);

                int index = 0;
                for (int i = 0; i < nums[1]; i++) {
                    for (int j = 0; j < newNumbers.size() ; j++) {
                        ++index;
                        if(index == indices[i]) {
                            newNumbers.remove(j);
                            index = 0;
                            --j;
                        }
                    }
                    index = 0;
                }
                for (int i = 0; i < newNumbers.size() ; i++) {
                    output.print(newNumbers.get(i)+" ");
                }
                output.close();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Exception: Cannot open file");
        }
    }

    public static int [] parseToInt(String [] str){
        int [] num = new int[str.length];

        for (int i = 0; i < str.length ; i++) {
            num[i] = Integer.parseInt(str[i]);
        }
        return num;
    }
    public static ArrayList<String> getIntegers(String[] str){
        ArrayList<String> list= new ArrayList<>(str.length);

        for (int i = 0; i < str.length ; i++) {
            list.add(str[i]);
        }
        return list;
    }
}
