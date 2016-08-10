package Lesson9.HomeWork;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by user on 10.08.16.
 */
public class ThreadData implements Runnable {
    private DataInputStream inputFromClient;
    private ArrayList<DataOutputStream> arrayList;
    private String message = "";

    @Override
    public void run() {
        try {
            while (true){
                message = inputFromClient.readUTF();
                for (int i = 0; i < arrayList.size(); i++) {
                    arrayList.get(i).writeUTF(message);

                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ThreadData(ArrayList<DataOutputStream> arrayList , DataInputStream inputFromClient) {
        this.inputFromClient = inputFromClient;
        this.arrayList = arrayList;
    }
}
