package Lesson9.HomeWork;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Created by user on 10.08.16.
 */
public class Client extends Application {
    private Socket socket;
    private ObjectOutputStream toServer;
    private ObjectInputStream inputFromServer;
    @Override
    public void start(Stage primaryStage) throws Exception {
        GridPane gridPane = new GridPane();
        gridPane.setHgap(10);
        gridPane.setVgap(2);

        Label lbName = new Label("Client name: ");
        Label lbMessage = new Label("Message: ");
        gridPane.add(lbName,0,0);
        gridPane.add(lbMessage,0,1);

        TextField tfName = new TextField("");
        TextField tfMessage = new TextField("");

        gridPane.add(tfName,1,0);
        gridPane.add(tfMessage,1,1);

        Button btSubmit = new Button("Submit");
        gridPane.add(btSubmit,2,1);

        TextArea textArea = new TextArea();
        VBox commonPane = new VBox(gridPane,textArea);
        commonPane.setPrefSize(400,250);

        Scene scene = new Scene(commonPane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Client");
        primaryStage.show();


        btSubmit.setOnAction(event -> {
            try {

                toServer = new ObjectOutputStream(socket.getOutputStream());

                String  name = tfName.getText();
                String message = tfMessage.getText();


                Data s = new Data(name, message);
                toServer.writeObject(s);
            }
            catch (UnknownHostException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    socket = new Socket("localhost", 8123);

                    while (true) {
                        inputFromServer = new ObjectInputStream(socket.getInputStream());
                        Data data = (Data) inputFromServer.readObject();
                        Platform.runLater(() -> {
                            textArea.appendText(data.name+" : "+data.message+ "\n");

                        });

                    }
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }
}
