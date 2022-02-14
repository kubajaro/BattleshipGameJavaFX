package com.kodilla.battleship;

import javafx.scene.Parent;
import javafx.scene.image.Image;
import javafx.scene.layout.*;

import java.awt.*;

public class StartScreen {
    static Image image = new Image("battleship.jpg");

    public static Parent startScreen(){
        BorderPane root = new BorderPane();
        root.setPrefSize(700, 550);
        BackgroundSize bgsize = new BackgroundSize(540.0, 360.0, true, true, true, false);
        BackgroundImage backgroundImage = new BackgroundImage(image, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, bgsize);
        Background background = new Background(backgroundImage);
        root.setBackground(background);

        return root;
    }
}
