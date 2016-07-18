package Lesson1.first;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;

/**
 * Created by user on 18.07.16.
 */
public class Task2054 {
    public static void main(String[] args) {
        File file = new File("Lesson1/texts/input_2054.txt");
        if(!file.exists()){
            System.out.println("Cannot open file");
            System.exit(1);
        }

        try(Scanner input = new Scanner(file)){
            int count = 0;
            int index = 0;
            SortedMap<Integer, SortedSet<Integer>> map = new TreeMap<>();
            while(input.hasNext()){
                String line = input.nextLine();
                try {
                    if(count == 0) {
                        count = Integer.parseInt(line);
                        if(count<1  && count>10000)
                            break;
                    }
                    else {
                        --count;
                        String [] array = line.split(" ");
                        ++index;
                        for (int i = 0; i < array.length; i++) {
                            Integer value =Integer.parseInt(array[i]);
                            if(!map.containsKey(value)){
                                SortedSet<Integer> t = new TreeSet<>();
                                t.add(index);
                                map.put(value, t);
                            }else {
                                SortedSet<Integer> t = map.get(value);
                                t.add(index);
                                map.put(value,t);
                            }
                        }
                        if(count==0)
                            break;
                    }
                }catch (NumberFormatException ne){

                }
            }

            System.out.println(map);
            if(map.size()>0){
                PrintWriter output = new java.io.PrintWriter("Lesson1/texts/output_2054.txt");

                Set<Map.Entry<Integer, SortedSet<Integer>>> entrySet = map.entrySet();
                for (Map.Entry<Integer, SortedSet<Integer>> entry: entrySet) {
                    output.print(entry.getKey()+" ");
                    SortedSet<Integer> values = entry.getValue();
                    for(Integer e: values){
                        output.print(e+" ");
                    }
                    output.println();
                }
                output.close();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Exception: Cannot open file");
        }
    }
}
