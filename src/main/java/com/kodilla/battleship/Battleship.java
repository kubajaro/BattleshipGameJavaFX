package com.kodilla.battleship;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Random;

public class Battleship extends Application {

    private boolean running = false;
    private Board enemyBoard, playerBoard;

    private int shipToPlace = 5;

    private boolean enemyTurn = true;

    private Random random = new Random();

    private Parent createContent(){
     return null;
    }

    private void enemyMove(){

    }

    private void startGame(){

    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Battleship Game");

        PaneOrganizer organizer = new PaneOrganizer();
        Scene scene = new Scene(organizer.getRoot());

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {

    }
}
