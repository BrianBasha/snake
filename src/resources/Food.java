package resources;

import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Food extends GameObject{
    private String image = "src/resources/food.png";

    public Food(){
        try {
            setImage(new Image(new FileInputStream(image)));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void spawn(AnchorPane pane){
        setLayoutX(((int) (Math.random() * 19)) * 25);
        setLayoutY(((int) (Math.random() * 19)) * 25);
        pane.getChildren().add(this);
    }

    public void die(){
        setLayoutX(((int) (Math.random() * 19)) * 25);
        setLayoutY(((int) (Math.random() * 19)) * 25);
    }
}
