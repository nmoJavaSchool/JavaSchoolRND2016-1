package Lesson11.HomeWork;

import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;

/**
 * Created by user on 17.08.16.
 */
public class TestTask11 {
    @Test
    public void testIteratorForNull() {
        String path = System.getProperty("user.dir") +"/target/classes/";

        File file = new File(path +"input.txt");
        if(!file.exists()){
            System.out.println("Cannot open file");
            System.exit(1);
        }

        ArrayList<String> listOfWords = new ArrayList<>();

        try(Scanner input = new Scanner(file)){

            while(input.hasNext()){
                String line = input.nextLine();
                if(line.length()!=0)
                    listOfWords.addAll(Arrays.asList(line.split("\\s")));
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Exception: Cannot open file");
        }


        int sum = 0;
        for (int i = 0; i <listOfWords.size() ; i++) {
            sum += listOfWords.get(i).length();
        }

        int sizeofPool = Lesson11.HomeWork.ReadFromPool.getSizeOfPool(path+"Pool.txt");

        int stepOfArrayList = listOfWords.size() / sizeofPool;

        ArrayList<CounterThread> listOfThreads = new ArrayList<>();
        for (int i = 0; i < listOfWords.size(); ) {
            int end;
            if(i+stepOfArrayList < listOfWords.size())
                end = i+stepOfArrayList;
            else
                end = listOfWords.size();
            CounterThread thread = new CounterThread(listOfWords,i,end);
            listOfThreads.add(thread);
            thread.start();
            i += stepOfArrayList;
        }

        int sumOfCharacters = 0;

        for (int i = 0; i < listOfThreads.size(); ++i ) {
            try {
                listOfThreads.get(i).join();
                sumOfCharacters += listOfThreads.get(i).getSumOfCharacter();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        assertEquals(sum, sumOfCharacters);
    }
}
