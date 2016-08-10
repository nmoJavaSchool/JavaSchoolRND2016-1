package Lesson9.HomeWork;

import javafx.application.Platform;
import javafx.scene.control.TextArea;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Date;

/**
 * Created by user on 10.08.16.
 */
public class ThreadData implements Runnable {
    private Socket socket;
    private int index;
    private TextArea textArea;
    public ThreadData(Socket socket, TextArea textArea, int index) {
        this.socket = socket;
        this.textArea = textArea;
        this.index = index;
    }

    @Override
    public void run() {
        Platform.runLater(() -> textArea.appendText("Connected to a client"+ index +" at " + new Date() + "\n"));

        try{
            while (true) {

                ObjectInputStream inputFromClient = new ObjectInputStream(
                        socket.getInputStream());
                ObjectOutputStream outputToClient = new ObjectOutputStream(
                        socket.getOutputStream());

                Data data = (Data) inputFromClient.readObject();




                Platform.runLater(() -> {
                    textArea.appendText(data.name+" : "+data.message+ "\n");
                    textArea.appendText("------------------------------------------------\n");
                });

                outputToClient.writeObject(data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
