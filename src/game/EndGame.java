package game;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.SubScene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import resources.GameButton;


public class EndGame extends SubScene {
    private String BACKGROUND = "/resources/grey.png";

    public EndGame(VBox menuPane, double width, double length, int score) {
        super(menuPane, width, length);
        initializeMenu(score, menuPane);
    }

    public void initializeMenu(int score, VBox menuPane){
        createStartButton(menuPane);
        createScoreLabel(score, menuPane);
        createMainMenuButton(menuPane);
        menuPane.setAlignment(Pos.CENTER);
        menuPane.setSpacing(20);
        BackgroundImage image = new BackgroundImage(new Image(BACKGROUND,300, 300, true, false),
                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, null);
        menuPane.setBackground(new Background(image));
    }

    public void createStartButton(VBox menuPane){
        GameButton start = new GameButton("New Game");
        start.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                GameScreen myGame = new GameScreen();
                Stage stage = (Stage) start.getScene().getWindow();
                stage.setScene(myGame.getScene());
                myGame.startGame();
            }
        });
        menuPane.getChildren().add(start);
    }

    public void createScoreLabel(int gameScore, VBox menuPane){
        Label scoreLabel = new Label("Score: " + gameScore);
        menuPane.getChildren().add(scoreLabel);
    }

    public void createMainMenuButton(VBox menuPane){
        GameButton mainMenu = new GameButton("Main Menu");
        mainMenu.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Stage stage = (Stage) mainMenu.getScene().getWindow();
                MainMenu e = new MainMenu();
                stage.setScene(e.getMenuScene());
            }
        });
        menuPane.getChildren().add(mainMenu);
    }
}
