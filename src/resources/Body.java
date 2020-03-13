package resources;

import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Body extends GameObject{
    private GameObject prevOb;
    private String image = "src/resources/snake.png";

    public Body(GameObject prevOb){
        this.prevOb = prevOb;
        try {
            setImage(new Image(new FileInputStream(image)));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void spawn(AnchorPane pane){
        setLayoutX(prevOb.getPrevX());
        setLayoutY(prevOb.getPrevY());
        pane.getChildren().add(this);
    }

    public void move(){
        setPrevX((int) getLayoutX());
        setPrevY((int) getLayoutY());
        setLayoutX(prevOb.getPrevX());
        setLayoutY(prevOb.getPrevY());
    }
}
