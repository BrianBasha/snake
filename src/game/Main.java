package game;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        MainMenu mainMenu = new MainMenu();
        primaryStage.setScene(mainMenu.getMenuScene());
        primaryStage.setTitle("Snake");
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
