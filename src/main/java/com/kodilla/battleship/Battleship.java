package com.kodilla.battleship;

import javafx.application.Application;
import javafx.stage.Stage;

public class Battleship extends Application {
    CreateStage createStage = new CreateStage();
    private Stage mainStage = createStage.createStartStage();

    @Override
    public void start(Stage primaryStage) {
        mainStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}