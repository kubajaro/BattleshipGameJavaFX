package com.kodilla.battleship;

import javafx.scene.Parent;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import javax.swing.plaf.basic.BasicTreeUI;
import java.awt.event.MouseEvent;
import java.beans.EventHandler;

public class Board extends Parent {
    private VBox rows = new VBox();
    private boolean enemy = false;
    public int ship = 5;

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
