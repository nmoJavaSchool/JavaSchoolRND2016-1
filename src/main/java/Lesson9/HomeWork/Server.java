package Lesson9.HomeWork;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by user on 10.08.16.
 */
public class Server extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        TextArea textArea = new TextArea();
        ScrollPane scrollPane = new ScrollPane(textArea);

        primaryStage.setTitle("Server");
        primaryStage.setScene(new Scene(scrollPane));
        primaryStage.show();
        new Thread(() -> {
            try {
                ServerSocket serverSocket = new ServerSocket(8123);
                Platform.runLater(() -> textArea.appendText("MultiThread started at " + new Date() + "\n"));
                ArrayList<DataOutputStream> arrayList = new ArrayList<>();

                while(!serverSocket.isClosed()) {
                    Socket socket = serverSocket.accept();
                    InetAddress ipAddress = socket.getInetAddress();

                    Platform.runLater(() -> textArea.appendText("Connection from Socket[/"+ipAddress.getHostAddress()
                            +",localport="+socket.getPort()+"] at " + new Date() + "\n"));

                    DataInputStream inputFromClient = new DataInputStream( socket.getInputStream());
                    DataOutputStream outputToClient = new DataOutputStream( socket.getOutputStream());

                    arrayList.add(outputToClient);

                    ThreadData data = new ThreadData(arrayList,inputFromClient);
                    Thread thread = new Thread(data);
                    thread.start();

                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
