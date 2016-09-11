package Lesson18.HomeWork;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Created by user on 11.09.16.
 */
public class ProxyApp extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        StackPane pane = new StackPane();
        pane.setPrefSize(200, 200);
        VBox vbox = new VBox();


        Button button = new StyledButton();
        button.setText("StyledButton");
        ((StyledButton) button).doStyle();

        Button proxyButton = new ProxyButton();
        ((ProxyButton) proxyButton).doStyle();

        vbox.getChildren().add(button);
        vbox.getChildren().add(proxyButton);
        pane.getChildren().add(vbox);
        Scene scene = new Scene(pane);

        primaryStage.setTitle("Proxy");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
