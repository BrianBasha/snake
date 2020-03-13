package resources;

import javafx.scene.image.ImageView;

public class GameObject extends ImageView {
    private int prevX;
    private int prevY;

    public GameObject(){
        setFitHeight(25);
        setFitWidth(25);
    }

    public int getPrevX(){
        return prevX;
    }

    public int getPrevY(){
        return prevY;
    }

    public void setPrevX(int prevX) {
        this.prevX = prevX;
    }

    public void setPrevY(int prevY) {
        this.prevY = prevY;
    }
}
