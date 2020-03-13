package resources;

import javafx.scene.control.Button;
import javafx.scene.text.Font;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class GameButton extends Button {
    private String FONT = "src/resources/font.ttf";

    public GameButton(String text){
        setText(text);
        try {
            setFont(Font.loadFont(new FileInputStream(FONT), 26));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
