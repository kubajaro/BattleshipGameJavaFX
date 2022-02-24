package com.kodilla.battleship;

import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class RestartGame {
    static Stage window;

    public static void restartGame(Button restartGameButton){
        window = (Stage) restartGameButton.getScene().getWindow();
        Platform.runLater(() -> {
           try {
               window.close();
               new Battleship().start(new Stage());
           } catch (Exception e) {
               e.printStackTrace();
           }
       });

    }
}
