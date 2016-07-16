package Lesson1.first;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Created by user on 16.07.16.
 */
public class Task2036 {
    public static void main(String[] args) {
        File file = new File("Lesson1/texts/input_2036.txt");
        if(!file.exists()){
            System.out.println("Cannot open file");
            System.exit(1);
        }

        try(Scanner input = new Scanner(file)){
            int count = 0;
            PrintWriter output = new java.io.PrintWriter("Lesson1/texts/output_2036.txt");
            while(input.hasNext()){
                String line = input.next();
                try {
                    if(count == 0)
                        count = Integer.parseInt(line);
                    else {
                        --count;
                        int counter = 0;
                        for(int i=0; i<line.length(); ++i){
                            char sym = line.charAt(i);
                            if(sym == 'e' || sym == 'y'|| sym == 'u'
                                    || sym == 'i'|| sym == 'o' || sym == 'a'){
                                ++counter;
                                if(counter == 3) break;

                            }else{
                                counter = 0;
                            }
                        }
                        if(counter<3)
                            output.println(line);

                        if(count ==0) break;
                    }
                }catch (NumberFormatException ne){

                }
            }
            output.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Exception: Cannot open file");
        }
    }
}
