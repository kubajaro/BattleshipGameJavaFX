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

    StartGameProcess gameStarter = new StartGameProcess();

    Image image = new Image("battleship.jpg");
    BackgroundSize backgroundSize = new BackgroundSize(100, 100, false, false, true, false);

    Background background = new Background(new BackgroundImage(image, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize));

    public Stage createStartStage(){
        Pane root = new Pane();
        root.setPrefSize(800, 500);

        startScene = new Scene(root);
        mainStage = new Stage(StageStyle.DECORATED);
        mainStage.setTitle("Battleship");

        startGameButton = new Button("Start game");
        startGameButton.setOnAction(e -> switchScene(createGameScene()));
        startGameButton.setLayoutX(350);
        startGameButton.setLayoutY(350);
        startGameButton.setSkin(new StartGameButtonAnimation(startGameButton));

        root.setBackground(background);
        root.getChildren().add(startGameButton);
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