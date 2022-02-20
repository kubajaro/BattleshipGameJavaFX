package com.kodilla.battleship;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class CreateStage {
    private Scene gameScene;

    private Stage mainStage;
    private Scene startScene;
    private Button startGameButton;

    GameStarter gameStarter = new GameStarter();

    private Image image = new Image("file: battleship.png");
    BackgroundSize backgroundSize = new BackgroundSize(100, 100, false, false, true, false);

    Background background = new Background(new BackgroundImage(image, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize));

    public Stage createStartStage(){
        BorderPane root = new BorderPane();
        root.setPrefSize(800, 550);


        startScene = new Scene(root);
        mainStage = new Stage(StageStyle.DECORATED);
        mainStage.setTitle("Battleship");
        startGameButton = new Button("Start game");
        startGameButton.setOnAction(e -> switchScene(createGameScene()));

        root.setBackground(background);
        root.setCenter(startGameButton);
        mainStage.setScene(startScene);

        return mainStage;
    }

    private Scene createGameScene(){
        gameScene = new Scene(gameStarter.createContent());
        return gameScene;
    }

    public void switchScene(Scene scene){
        mainStage.setScene(scene);
    }
}