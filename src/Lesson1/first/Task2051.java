package Lesson1.first;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by user on 17.07.16.
 */
public class Task2051 {
    static class Data<B,N>{
        B bracket;
        N number;

        public Data(B bracket, N number) {
            this.bracket = bracket;
            this.number = number;
        }

        public B getBracket() {
            return bracket;
        }

        public N getNumber() {
            return number;
        }
    }
    public static void main(String[] args) {
//        System.out.println(new File("").getAbsolutePath());
//        File file = new File(new File("").getAbsolutePath()+"/out/production/JavaSchoolRND2016/Lesson1/texts/input_2051.txt");
        File file = new File("Lesson1/texts/input_2051.txt");
        if(!file.exists()){
            System.out.println("Cannot open file");
            System.exit(1);
        }

        try(Scanner input = new Scanner(file)){

            PrintWriter output = new PrintWriter("Lesson1/texts/output_2051.txt");
            while(input.hasNext()){
                String line = input.nextLine();
                if(line.length()<=1000) {
                    String result = "";
                    String []sym = line.split("");

                    if(sym.length%2==0) {
                        LinkedList<Data<String, Integer>> brackets = new LinkedList<>();
                        String[] str = new String[sym.length];
                        for (int i = 0; i < sym.length; i++) {
                            if (sym[i].equals("(")) {
                                brackets.add(new Data<>(sym[i], i));
                            } else {
                                if (brackets.size() == 0) {
                                    System.out.println("Error");
                                    break;
                                }
                                Data<String, Integer> value = brackets.removeLast();
                                if (value.getBracket().equals("(")) {

                                    str[value.getNumber()] = (value.getNumber() + 1) + " " + (i + 1);
                                }

                            }
                        }
                        for (int i = 0; i < str.length; i++) {
                            if(str[i]!=null)
                                output.println(str[i]);
                        }
                    }
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
