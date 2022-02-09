package com.kodilla.battleship;

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

    }

    public Pane getRoot(){
        return main;
    }
}
