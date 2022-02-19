package com.kodilla.battleship;

import java.util.Random;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import com.kodilla.battleship.Board.Cell;
import javafx.stage.StageStyle;


public class Battleship extends Application {
    private Scene gameScene;

    private Stage mainStage;
    private Scene startScene;
    private Button startGameButton;

    private boolean running = false;
    private Board enemyBoard, playerBoard;

    private int shipsToPlace = 5;

    private boolean enemyTurn = false;

    private Random random = new Random();

    private EnemyMove enemyMove = new EnemyMove();

    private Parent createContent() {
        BorderPane root = new BorderPane();
        root.setPrefSize(800, 550);

        BackgroundImage backgroundImage = new BackgroundImage(new Image("file:battleship.jpg", 800,550,false,true),
                BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT ,BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
        root.setBackground(new Background(backgroundImage));


        Button restartGame = new Button("Restart game");
        restartGame.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                running = false;
            }
        });
        root.setRight(restartGame);


        //root.setRight(new Text("RIGHT SIDEBAR - CONTROLS"));

        enemyBoard = new Board(true, event -> {
            if (!running)
                return;

            Cell cell = (Cell) event.getSource();
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

            Cell cell = (Cell) event.getSource();
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
        type = 5;
    }

    private Stage createStartStage(){
        BorderPane root = new BorderPane();
        root.setPrefSize(800, 550);

        BackgroundImage backgroundImage = new BackgroundImage(new Image("file:battleship.jpg", 800,550,false,true),
                BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT ,BackgroundPosition.CENTER, BackgroundSize.DEFAULT);

        startScene = new Scene(root);
        mainStage = new Stage(StageStyle.DECORATED);
        mainStage.setTitle("Battleship");
        startGameButton = new Button("Start game");
        startGameButton.setOnAction(e -> switchScene(createGameScene()));

        root.setCenter(startGameButton);
        root.setBackground(new Background(backgroundImage));
        mainStage.setScene(startScene);

        return mainStage;
    }

    private Scene createGameScene(){
        gameScene = new Scene(createContent());
        return gameScene;
    }

    public void switchScene(Scene scene){
        mainStage.setScene(scene);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        mainStage = createStartStage();
        mainStage.show();

    }

    public static void main(String[] args) {
        launch(args);
        EnemyMove enemyMove = new EnemyMove();
        enemyMove.createCellList(10,0);
    }
}