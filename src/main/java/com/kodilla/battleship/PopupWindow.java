package com.kodilla.battleship;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class PopupWindow {

    public static void endGamePopup(String title, String message){
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        window.setMinWidth(250);

        Label label = new Label();
        label.setText(message);
        Button closeButton = new Button("Close the window");
        closeButton.setOnAction(e -> window.close());

        VBox layout = new VBox(10);
        layout.setPrefSize(100, 100);
        layout.getChildren().addAll(label, closeButton);
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait();
    }

    public static void displayGameRulesPopup(){
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Game rules");
        window.setMinWidth(250);

        Label label = new Label();
        label.setText("1. Place your ships on the players board"+
                "\n     Right mouse button places the ship vertically" +
                "\n     Left mouse button places the ship horizontally" +
                "\n 2.Then try to shot our opponents on the CPU board" +
                "\n 3. First who shots all ships of his opponent wins!" +
                " \n \n Good luck!");
        Button closeButton = new Button("Begin");
        closeButton.setOnAction(e -> window.close());

        VBox layout = new VBox(10);
        layout.setPrefSize(450, 200);
        layout.getChildren().addAll(label, closeButton);
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait();
    }

}