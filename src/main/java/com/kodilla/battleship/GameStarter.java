package com.kodilla.battleship;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.*;

import java.util.Random;

public class GameStarter {
    private boolean running = false;
    private Board enemyBoard, playerBoard;
    private int shipsToPlace = 5;
    private boolean enemyTurn = false;
    private Random random = new Random();
    private EnemyMove enemyMove = new EnemyMove();


    public Parent createContent() {
        BorderPane root = new BorderPane();
        root.setPrefSize(600, 550);

        enemyBoard = new Board(true, event -> {

            if (!running)
                return;

            Board.Cell cell = (Board.Cell) event.getSource();
            if (cell.wasShot)
                return;

            enemyTurn = !cell.shoot();

            if (enemyBoard.ships == 0) {
                System.out.println("YOU WIN");
                PopupWindow.endGamePopup("YOU WIN", "Congratulations, you won!");
            }

                if (enemyTurn)
                    enemyMove.enemyMove(playerBoard);
        });

        playerBoard = new Board(false, event -> {
            if (running)
                return;

            Board.Cell cell = (Board.Cell) event.getSource();
            if (playerBoard.placeShip(new Ship(shipsToPlace, event.getButton() == MouseButton.PRIMARY), cell.x, cell.y)) {
                if (--shipsToPlace == 0) {
                    startGame();
                }
            }
        });

        Label playerBoardLabel = new Label("Your board"
                +"\n place your ships here.", playerBoard);
        Label enemyBoardLabel = new Label("Enemy board"
                +"\n after placing your ships, " +
                "\ntry to shoot enemy's ships", enemyBoard);

        VBox vbox = new VBox(50, enemyBoardLabel, enemyBoard, playerBoardLabel, playerBoard);
        vbox.setAlignment(Pos.CENTER);

        root.setLeft(vbox);

        Button restartGameButton = new Button("Restart game");
        restartGameButton.setOnAction(e -> {
            RestartGame.restartGame(restartGameButton);
        });

        BorderPane buttonBorderPane = new BorderPane();
        buttonBorderPane.setCenter(restartGameButton);
        root.setRight(buttonBorderPane);

        BorderPane.setMargin(buttonBorderPane, new Insets(50));
        BorderPane.setMargin(vbox, new Insets(50));

        return root;
    }

    private void startGame() {
        // place enemy ships
        int type = 5;

        while (type > 0) {
            int x = random.nextInt(10);
            int y = random.nextInt(10);

            if (enemyBoard.placeShip(new Ship(type, Math.random() < 0.5), x, y)) {
                type--;
            }
        }
        running = true;
    }

}
