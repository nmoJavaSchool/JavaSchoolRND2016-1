package Lesson9.HomeWork;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

/**
 * Created by user on 10.08.16.
 */
public class Server extends Application {
    private int countThreads = 0;
    @Override
    public void start(Stage primaryStage) throws Exception {
        TextArea textArea = new TextArea();
        ScrollPane scrollPane = new ScrollPane(textArea);

        primaryStage.setScene( new Scene(scrollPane));
        primaryStage.setTitle("Server");
        primaryStage.show();
        textArea.appendText("------------------------------------------------\n");

        new Thread(() -> {
            try {
                ServerSocket serverSocket = new ServerSocket(8123);
                Platform.runLater(() -> textArea.appendText(primaryStage.getTitle()
                        + " started at " + new Date() + "\n"));
                while(true) {
                    Socket socket = serverSocket.accept();
                    ++countThreads;

                    new Thread(new ThreadData(socket, textArea, countThreads)).start();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
