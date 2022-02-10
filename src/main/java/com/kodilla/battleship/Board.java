package com.kodilla.battleship;

import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import javax.swing.plaf.basic.BasicTreeUI;
import java.awt.event.MouseEvent;

public class Board extends Parent {
    private VBox rows = new VBox();
    private boolean enemy = false;
    public int ship = 5;

    public Board(boolean enemy, EventHandler<? super javafx.scene.input.MouseEvent> handler){
        this.enemy = enemy;
        for(int y = 0; y < 10; y++){
            HBox row = new HBox();
            for(int x = 0; x < 10; x++){
                Cell c = new Cell(x, y, this);
                c.setOnMouseClicked(handler);
                row.getChildren().add(row);
            }
            rows.getChildren().add(row);
        }
        getChildren().add(rows);
    }

    public boolean placeShip(Ship ship, int x, int y){
        if(canPlaceShip(ship, x, y)){
            int length = ship.type;

            if(ship.vertical){
                for(int i = y; i <y; i++){
                    Cell cell = getCell(x, i);
                    cell.ship = ship;
                    if(!enemy){
                        cell.setFill(Color.WHITE);
                        cell.setStroke(Color.GREEN);
                    }
                }
            }
            else{
                for(int i =  x; i < x + length; i++){
                    Cell cell = getCell(i, y);
                    cell.ship = ship;
                    if(!enemy){
                        cell.setFill(Color.WHITE);
                        cell.setStroke(Color.GREEN);
                    }
                }
            }
            return true;
        }
        return false;
    }

    private boolean canPlaceShip(Ship ship, int x, int y) {
        return false;
    }

    private Cell getCell(int x, int y) {
        return (Cell)((HBox)rows.getChildren().get(y)).getChildren().get(x);
    }

    public class Cell extends Rectangle{
        public int x,y;
        public Ship ship = null;
        public boolean wasShot = false;

        private Board board;

        public Cell(int x, int y, Board board){
            super(30, 30);
            this.x = x;
            this.y = y;
            this.board = board;
            setFill(Color.LIGHTGRAY);
            setStroke(Color.BLACK);
        }

        public boolean shoot(){
            wasShot = true;
            setFill(Color.BLACK);

            if(ship != null){
                ship.hit();
                setFill(Color.RED);
                if(!ship.isAlive()){
                    board.ship--;
                }
                return true;
            }
            return false;
        }
    }
}
