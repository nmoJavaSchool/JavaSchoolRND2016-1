package Lesson15.HomeWork;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by user on 28.04.16.
 */
public class Server extends Application {
    ServerSocket serverSocket = null;
    final int COUNTER_CLIENT = 2;
    @Override
    public void start(Stage primaryStage) throws Exception {
        TextArea textArea = new TextArea();
        ScrollPane scrollPane = new ScrollPane(textArea);

        primaryStage.setTitle("Server");
        primaryStage.setScene(new Scene(scrollPane));
        primaryStage.show();

        Thread mainThread = new Thread(() -> {
            ArrayList<DataOutputStream> arrayList = new ArrayList<>();
            try {
                serverSocket = new ServerSocket(8123);
                Platform.runLater(() -> textArea.appendText("MultiThread started at " + new Date() + "\n"));

                int counter = 0;

                while(!serverSocket.isClosed()) {
                    Socket socket = serverSocket.accept();
                    InetAddress ipAddress = socket.getInetAddress();

                    Platform.runLater(() -> textArea.appendText("Connection from Socket[/"+ipAddress.getHostAddress()
                            +",localport="+socket.getPort()+"] at " + new Date() + "\n"));

                    DataInputStream inputFromClient = new DataInputStream( socket.getInputStream());
                    DataOutputStream outputToClient = new DataOutputStream( socket.getOutputStream());

                    if(counter <COUNTER_CLIENT) {
                        arrayList.add(outputToClient);
                        ChatThread data = new ChatThread(arrayList, inputFromClient);
                        Thread thread = new Thread(data);
                        thread.setDaemon(true);
                        thread.start();
                    }else{
                        outputToClient.writeUTF("Можно запускать только "+COUNTER_CLIENT+" клиентов");
                    }
                    ++counter;

                }
            } catch (IOException e) {
            }finally {
                arrayList.clear();
                return;
            }
        });
        mainThread.setDaemon(true);
        mainThread.start();

        primaryStage.setOnCloseRequest(e ->{
            try {
                serverSocket.close();
            } catch (IOException e1) {
            }
        });
    }


}
