package com.kodilla.battleship;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class CreateStage {
    private Scene gameScene;

    private Stage mainStage;
    private Scene startScene;
    private Button startGameButton;

    GameStarter gameStarter = new GameStarter();

    public Stage createStartStage(){
        BorderPane root = new BorderPane();
        root.setPrefSize(800, 550);

        BackgroundImage backgroundImage = new BackgroundImage(new Image("file:battleship.jpg", 800,550,false,true),
                BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT , BackgroundPosition.CENTER, BackgroundSize.DEFAULT);

        startScene = new Scene(root);
        mainStage = new Stage(StageStyle.DECORATED);
        mainStage.setTitle("Battleship");
        startGameButton = new Button("Start game");
        startGameButton.setOnAction(e -> switchScene(createGameScene()));

        root.setCenter(startGameButton);
        root.setBackground(new Background(backgroundImage));
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
