package com.kodilla.battleship;

import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;

public class RestartGameButton {

    public static BorderPane restartGameButton() {
        Button restartGameButton = new Button("Restart game");

        restartGameButton.setOnAction(e -> {
            RestartGame.restartGame(restartGameButton);
        });

        BorderPane buttonBorderPane = new BorderPane();
        buttonBorderPane.setCenter(restartGameButton);

        return buttonBorderPane;
    }
}
