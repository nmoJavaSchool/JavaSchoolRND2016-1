package Lesson11.HomeWork;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by user on 16.08.16.
 */
public class ReadFromPool {
    public static int getSizeOfPool(String path){
        File file = new File(path);
        if(!file.exists()){
            System.out.println("Cannot open file");
            System.exit(1);
        }

        try(Scanner input = new Scanner(file)){
            int sum = 0;
            while(input.hasNext()){
                String line = input.next();
                try {
                    int number = Integer.parseInt(line);
                    return number;
                }catch (NumberFormatException ne){

                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Exception: Cannot open file");
        }
        return 1;
    }
}
