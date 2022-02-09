package com.kodilla.battleship;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Battleship extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Battleship Game");

        PaneOrganizer organizer = new PaneOrganizer();
        Scene scene = new Scene(organizer.getRoot());

        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
