package com.kodilla.battleship;

import javafx.application.Platform;
import javafx.stage.Stage;

public class RestartGame {

    public static void restartGame(){
        Platform.isImplicitExit();
        Platform.runLater(() -> {
           try {
               new Battleship().start(new Stage());
           } catch (Exception e) {
               e.printStackTrace();
           }
       });

    }
}
