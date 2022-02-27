package com.kodilla.battleship;

import javafx.animation.FillTransition;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

public class Cell extends Rectangle {

    public int x, y;
    public Ship ship = null;
    public boolean wasShot = false;

    private Board board;

    public Cell(int x, int y, Board board) {
        super(22, 22);
        this.x = x;
        this.y = y;
        this.board = board;
        setFill(Color.LIGHTGRAY);
        setStroke(Color.BLACK);
    }

    public boolean shoot() {
        wasShot = true;
        if(ship == null) {
            FillTransition missTransition = new FillTransition(Duration.seconds(0.5), this, Color.ORANGE, Color.BLACK);
            missTransition.play();
        }
        else if (ship != null) {
            ship.hit();
            FillTransition shotTransition = new FillTransition(Duration.seconds(0.5), this, Color.ORANGE, Color.RED);
            shotTransition.play();
            if (!ship.isAlive()) {
                board.ships--;
            }
            return true;
        }
        return false;
    }
}
