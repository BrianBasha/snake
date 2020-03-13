package game;

import javafx.animation.AnimationTimer;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.*;
import resources.*;

import java.util.stream.IntStream;

public class GameScreen {
    private int sizeX = 500;
    private int sizeY = 500;
    private AnchorPane gameLayout;
    private Scene gameScene;
    private SnakeHead mySnake = new SnakeHead();
    private Food snakeFood = new Food();
    private Body[] snakeBody = new Body[400];
    private AnimationTimer gameTime;
    private VBox menu = new VBox();

    public GameScreen(){
        gameLayout = new AnchorPane();
        gameScene = new Scene(gameLayout, sizeX, sizeY);
        BackgroundImage image = new BackgroundImage(new Image("/resources/gameB.png",500, 500, true, false),
                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, null);
        gameLayout.setBackground(new Background(image));
    }

    public Scene getScene(){
        return gameScene;
    }

    public void startGame(){
        mySnake.spawn(gameLayout);
        snakeFood.spawn(gameLayout);
        initializeM();
        startTime();
    }

    public void startTime(){
        final double[] lastTime = {System.nanoTime()};
        gameTime = new AnimationTimer() {
            @Override
            public void handle(long now) {
                if (now - lastTime[0] > 300000000){
                    mySnake.move();
                    checkCollision();
                    IntStream.range(0, mySnake.getSize()).forEach(i -> snakeBody[i].move());
                    lastTime[0] = now;
                }
            }
        };
        gameTime.start();
    }

    public void initializeM(){
        gameScene.addEventFilter(KeyEvent.KEY_PRESSED, (KeyEvent event) -> {
            if (event.getCode() == KeyCode.UP && mySnake.getLayoutY() - 25 != mySnake.getPrevY()){
                mySnake.setDirection("UP");
            }
            else if (event.getCode() == KeyCode.DOWN && mySnake.getLayoutY() + 25 != mySnake.getPrevY()){
                mySnake.setDirection("DOWN");
            }
            else if (event.getCode() == KeyCode.LEFT && mySnake.getLayoutX() - 25 != mySnake.getPrevX()){
                mySnake.setDirection("LEFT");
            }
            else if (event.getCode() == KeyCode.RIGHT && mySnake.getLayoutX() + 25 != mySnake.getPrevX()){
                mySnake.setDirection("RIGHT");
            }
            event.consume();
        });
    }

    public void checkCollision(){
        if (snakeFood.getLayoutX() == mySnake.getLayoutX() && snakeFood.getLayoutY() == mySnake.getLayoutY()){
            snakeFood.die();
            mySnake.addSize();
            addBody();
        }
        for (int i = 0; i < mySnake.getSize(); i++) {
            if (snakeBody[i].getLayoutX() == mySnake.getLayoutX() && snakeBody[i].getLayoutY() == mySnake.getLayoutY()){
                gameTime.stop();
                EndGame end = new EndGame(menu, 300, 300, mySnake.getSize());
                gameLayout.getChildren().add(end);
                end.setLayoutX(100);
                end.setLayoutY(100);
            }
        }
    }

    public void addBody(){
        if (mySnake.getSize() == 1){
            snakeBody[0] = new Body(mySnake);
            snakeBody[0].spawn(gameLayout);
        } else if (mySnake.getSize() > 1){
            snakeBody[mySnake.getSize() - 1] = new Body(snakeBody[mySnake.getSize() - 2]);
            snakeBody[mySnake.getSize() - 1].spawn(gameLayout);
        }
    }
}
