package com.kodilla.battleship;

import javafx.application.Platform;
import javafx.stage.Stage;

public class RestartGameButton {

    public static void restartGame(){
        Platform.runLater(() -> {
           try {
               new Battleship().start(new Stage());
           } catch (Exception e) {
               e.printStackTrace();
           }
       });

    }
}
