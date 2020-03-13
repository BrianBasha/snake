package game;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import resources.GameButton;

public class MainMenu{
    private Scene menuScene;
    private VBox menuPane;
    private String BACKGROUND = "/resources/grey.png";
    private GameScreen myGame = new GameScreen();

    public MainMenu() {
        initializeMenu();
        menuScene = new Scene(menuPane, 500, 500);
    }

    public Scene getMenuScene(){
        return menuScene;
    }

    public void initializeMenu(){
        menuPane = new VBox();
        createStartButton();
        createQuitButton();
        menuPane.setAlignment(Pos.CENTER);
        menuPane.setSpacing(20);
        BackgroundImage image = new BackgroundImage(new Image(BACKGROUND,500, 500, true, false),
                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, null);
        menuPane.setBackground(new Background(image));
    }

    public void createStartButton(){
        GameButton start = new GameButton("Start Game");
        start.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Stage stage = (Stage) start.getScene().getWindow();
                stage.setScene(myGame.getScene());
                myGame.startGame();
            }
        });
        menuPane.getChildren().add(start);
    }

    public void createQuitButton(){
        GameButton quit = new GameButton("Quit");
        quit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Stage stage = (Stage) quit.getScene().getWindow();
                stage.close();
            }
        });
        menuPane.getChildren().add(quit);
    }
}
