package Lesson1.HomeWork.first;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Created by user on 17.07.16.
 */
//TODO доделать эту задачу
public class Task2041 {
    public static void main(String[] args) {
        File file = new File("Lesson1/HomeWork/texts/input_2041.txt");
        if(!file.exists()){
            System.out.println("Cannot open file");
            System.exit(1);
        }

        try(Scanner input = new Scanner(file)){

            PrintWriter output = new PrintWriter("Lesson1/HomeWork/texts/output_2041.txt");
            while(input.hasNext()){
                String line = input.nextLine();
                if(line.length()<=1000) {
                    boolean flagPalindrom = true;
                    for (int i = 0; i < line.length()/2 ; i++) {
                        if(i != line.length()-1-i){
                            if(line.charAt(i) != line.charAt(line.length()-1-i))
                                flagPalindrom = false;
                        }
                    }
                    if(flagPalindrom)
                        output.println("YES");
                    else
                        output.println("NO");
                }
                break;
            }
            output.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Exception: Cannot open file");
        }
    }
}
