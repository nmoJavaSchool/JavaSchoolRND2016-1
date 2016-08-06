package Lesson2.HomeWork;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.*;

/**
 * Created by Askar on 15.07.16.
 */
public class Task {
    public static void main(String[] args) {

        File file = new File("Lesson2/HomeWork/input.txt");
        if(!file.exists()){
            System.out.println("Cannot open file");
            System.exit(1);
        }

        LinkedList<String> list = new LinkedList<>();

        try(Scanner input = new Scanner(file)){

            while(input.hasNext()){
                String line = input.nextLine();
                list.addAll(Arrays.asList(line.split("\\s")));
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Exception: Cannot open file");
        }

        Collections.sort(list);

        try {
            PrintStream output = new PrintStream("Lesson2/output.txt");
            for (int i = 0; i < list.size(); i++) {
                String value = list.get(i);
                if (value.length()>0)
                    output.println(list.get(i));
            }
            output.close();
        }catch (FileNotFoundException e){
            System.out.println("Cannot create output file.");
        }
    }
}
