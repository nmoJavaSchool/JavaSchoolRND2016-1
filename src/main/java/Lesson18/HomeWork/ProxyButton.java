package Lesson18.HomeWork;

import javafx.scene.control.Button;

/**
 * Created by user on 11.09.16.
 */
public class ProxyButton extends Button implements IProxy{

    @Override
    public void setTextForButton(String text) {
        setText(text);
    }

    @Override
    public void doStyle() {
        setText("ProxyButton");
        setStyle(
                "-fx-background-color: linear-gradient(#ff5400, #be1d00);\n" +
                        "    -fx-background-radius: 30;\n" +
                        "    -fx-background-insets: 0;\n" +
                        "    -fx-text-fill: white;"
        );
    }
}
