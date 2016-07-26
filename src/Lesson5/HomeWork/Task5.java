package Lesson5.HomeWork;

import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

/**
 * Created by user on 26.07.16.
 */
public class Task5 {
    public static void main(String[] args) {
        if(args.length==0){
            System.out.println("Launch the app with the URL parameter:\n Example: java Task5 google.ru");
            System.exit(1);
        }
        boolean flag = true;
        String url = args[0];
        while(flag) {
            try {
                String result = readContent(url);
                System.out.println(result);
                flag = false;
            } catch (IOException ex) {
                System.out.print("Try again: ");
                Scanner input= new Scanner(System.in);
                url = input.nextLine();
            }
        }

    }
    public static String readContent(String url) throws IOException{

        if(url.indexOf("http://")==-1){
            url = "http://" + url;
        }

        URL urlOfSite = new URL(url);
        Scanner input = new Scanner(urlOfSite.openStream());
        String line = "";
        while (input.hasNext()) {
            line += input.nextLine();
        }
        return line;
    }
}
