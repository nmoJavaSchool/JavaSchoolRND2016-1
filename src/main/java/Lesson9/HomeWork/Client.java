package Lesson9.HomeWork;

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
import java.io.EOFException;
import java.io.IOException;
import java.net.Socket;

/**
 * Created by user on 10.08.16.
 */
public class Client extends Application {
    private boolean isConnected = true;
    private Socket socket;
    private DataInputStream inputFromServer;
    private DataOutputStream outputToServer;

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

        Thread thread = new Thread(new Runnable() {
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
                        if (!socket.isConnected())
                            isConnected = false;
                    }

                    socket.close();
                    System.out.println("End");

                }catch (EOFException e) {
                    try {
                        inputFromServer.close();
                        outputToServer.close();
                        socket.close();
                        Thread.interrupted();
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                    return;
                }catch (IOException e) {
                    try {
                        inputFromServer.close();
                        outputToServer.close();
                        socket.close();
                        Thread.interrupted();
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                    return;
                }
            }
        });
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