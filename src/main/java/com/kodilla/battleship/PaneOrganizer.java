package com.kodilla.battleship;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.*;

public class PaneOrganizer {

    private BorderPane main;

    public PaneOrganizer(){
        main = new BorderPane();
        main.setStyle("-fx-background-color: grey;");
        main.setPrefHeight(500);
        main.setPrefWidth(500);
        createGrid();
    }

    public void createGrid(){
        GridPane grid = new GridPane();
        for(int i = 0; i<10; i++){
            grid.getColumnConstraints().add(new ColumnConstraints(50));
            grid.getRowConstraints().add(new RowConstraints(50));
        }
        for(int i = 0; i <10; i++){
            for(int j = 0; j < 10; j++){
                Button button = new Button();
                button.setPrefHeight(50);
                button.setPrefWidth(50);
                GridPane.setConstraints(button, j, i);
                grid.getChildren().add(button);

                button.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        System.out.println("Row: " + GridPane.getRowIndex(button));
                        System.out.println("Column: " + GridPane.getColumnIndex(button));
                        button.setStyle("-fx-background-color: black;");
                    }
                });
            }
        }
        main.getChildren().add(grid);
    }

    public Pane getRoot(){
        return main;
    }
}
