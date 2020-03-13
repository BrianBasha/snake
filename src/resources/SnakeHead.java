package resources;

import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class SnakeHead extends GameObject{
    private String direction;
    private int size = 0;
    private String image = "src/resources/snake.png";

    public SnakeHead(){
        setDirection("UP");
        try {
            setImage(new Image(new FileInputStream(image)));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public void spawn(AnchorPane pane){
        setLayoutX(225);
        setLayoutY(400);
        pane.getChildren().add(this);
    }

    public void move(){
        setPrevX((int) getLayoutX());
        setPrevY((int) getLayoutY());
        if (direction.equals("UP")){
            this.setLayoutY(this.getLayoutY() - 25);
        } else if (direction.equals("DOWN")){
            this.setLayoutY(this.getLayoutY() + 25);
        } else if (direction.equals("RIGHT")){
            this.setLayoutX(this.getLayoutX() + 25);
        } else if (direction.equals("LEFT")){
            this.setLayoutX(this.getLayoutX() - 25);
        }

        if (this.getLayoutX() >= 500){
            this.setLayoutX(0);
        } else if (this.getLayoutX() < 0){
            this.setLayoutX(475);
        }

        if (this.getLayoutY() >= 500){
            this.setLayoutY(0);
        } else if(this.getLayoutY() < 0){
            this.setLayoutY(475);
        }
    }

    public int getSize(){
        return size;
    }

    public void addSize(){
        size = size + 1;
    }

}
