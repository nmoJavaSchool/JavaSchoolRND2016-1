package Lesson15.HomeWork;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;


public class Client extends Application {
    private Socket socket;
    private DataInputStream inputFromServer;
    private DataOutputStream outputToServer;
    Thread thread;

    @Override
    public void start(Stage primaryStage) throws Exception {
        VBox vBox = new VBox();
        vBox.setSpacing(20);

        Label lbName = new Label("Name");
        Label lbEnterText = new Label("Enter text");
        TextField tfName = new TextField();
        TextField tfSend = new TextField();

        GridPane gridPane = new GridPane();
        gridPane.setVgap(5);
        gridPane.setHgap(5);
        gridPane.add(lbName,0,0);
        gridPane.add(lbEnterText,0,1);
        gridPane.add(tfName,1,0);
        gridPane.add(tfSend,1,1);

        TextArea textArea = new TextArea();
        ScrollPane scrollPane = new ScrollPane(textArea);


        vBox.getChildren().addAll(gridPane, scrollPane);

        primaryStage.setTitle("Client");
        primaryStage.setScene(new Scene(vBox));
        primaryStage.show();

        thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    socket = new Socket("localhost", 8123);
                    System.out.println("The network is connected.");

                    inputFromServer = new DataInputStream(
                            socket.getInputStream());

                    outputToServer = new DataOutputStream(
                            socket.getOutputStream());
                    while(socket.isConnected()){
                        String message = inputFromServer.readUTF();
                        textArea.appendText(message);
                    }

                    socket.close();
                    System.out.println("End");

                }catch (Exception e) {
                    try {
                        inputFromServer.close();
                        outputToServer.close();
                        socket.close();
                        Thread.interrupted();
                    } catch (IOException e1) {
                        return;
                    }
                    return;
                }
            }
        });
        thread.setDaemon(true);
        thread.start();

        tfSend.setOnKeyPressed(event -> {
            if(event.getCode() == KeyCode.ENTER){
                if(socket.isConnected()){
                    try {
                        outputToServer.writeUTF(tfName.getText()+" : "+tfSend.getText()+"\n");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

    }
}