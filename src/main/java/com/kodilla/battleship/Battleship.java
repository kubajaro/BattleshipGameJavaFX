package com.kodilla.battleship;

import javafx.application.Application;
import javafx.stage.Stage;

public class Battleship extends Application {
    private Stage mainStage;
    CreateStage createStage = new CreateStage();

    @Override
    public void start(Stage primaryStage) throws Exception {
        mainStage = createStage.createStartStage();
        mainStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}