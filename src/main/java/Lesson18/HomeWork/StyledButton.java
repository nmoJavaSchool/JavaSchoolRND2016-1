package Lesson18.HomeWork;

import javafx.scene.paint.Color;

/**
 * Created by user on 11.09.16.
 */
public class StyledButton extends javafx.scene.control.Button implements IProxy {


    @Override
    public void setTextForButton(String text) {
        setText(text);
    }

    @Override
    public void doStyle() {
        setStyle(
                "    -fx-background-color:" +
                        "        linear-gradient(#f0ff35, #a9ff00)," +
                        "        radial-gradient(center 50% -40%, radius 200%, #b8ee36 45%, #80c800 50%);" +
                        "    -fx-background-radius: 6, 5;" +
                        "    -fx-background-insets: 0, 1;" +
                        "    -fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.4) , 5, 0.0 , 0 , 1 );" +
                        "    -fx-text-fill: #395306;"
        );
    }
}
