package Lesson15.HomeWork;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.util.ArrayList;


public class ChatThread implements Runnable {
    private DataInputStream inputFromClient;
    private ArrayList<DataOutputStream> arrayList;
    private String message = "";

    @Override
    public void run() {
        try {
            while (arrayList.size()>0){
                message = inputFromClient.readUTF();
                for (int i = 0; i < arrayList.size(); i++) {
                    arrayList.get(i).writeUTF(message);

                }
            }
        } catch (Exception e) {
            return;
        }
    }

    public ChatThread(ArrayList<DataOutputStream> arrayList , DataInputStream inputFromClient) {
        this.inputFromClient = inputFromClient;
        this.arrayList = arrayList;
    }
}
