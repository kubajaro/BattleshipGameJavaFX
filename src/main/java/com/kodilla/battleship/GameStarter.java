package com.kodilla.battleship;

import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
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
        root.setPrefSize(800, 550);

        BackgroundImage backgroundImage = new BackgroundImage(new Image("file:battleship.jpg", 800,550,false,true),
                BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT , BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
        root.setBackground(new Background(backgroundImage));


        Button restartGame = new Button("Restart game");
        restartGame.setOnAction(e -> {
            running = false;
        });
        root.setRight(restartGame);


        //root.setRight(new Text("RIGHT SIDEBAR - CONTROLS"));

        enemyBoard = new Board(true, event -> {
            if (!running)
                return;

            Board.Cell cell = (Board.Cell) event.getSource();
            if (cell.wasShot)
                return;

            enemyTurn = !cell.shoot();


            if (enemyBoard.ships == 0) {
                System.out.println("YOU WIN");
                PopupWindow.displayPopup("YOU WIN", "Congratulations, you won!");
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

        VBox vbox = new VBox(50, enemyBoard, playerBoard);
        vbox.setAlignment(Pos.CENTER);

        root.setCenter(vbox);

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
