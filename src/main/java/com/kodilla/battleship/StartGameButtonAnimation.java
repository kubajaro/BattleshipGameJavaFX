package com.kodilla.battleship;

import javafx.animation.Interpolator;
import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
import javafx.scene.control.Button;
import javafx.scene.control.skin.ButtonSkin;
import javafx.util.Duration;

public class StartGameButtonAnimation extends ButtonSkin {

    public StartGameButtonAnimation(Button control) {
        super(control);
        final ScaleTransition buttonResizing = new ScaleTransition();

        buttonResizing.setDuration(Duration.millis(1000));
        buttonResizing.setNode(control);
        buttonResizing.setCycleCount(TranslateTransition.INDEFINITE);
        buttonResizing.setInterpolator(Interpolator.EASE_OUT);
        buttonResizing.setByX(0.35);
        buttonResizing.setByY(0.35);
        buttonResizing.setAutoReverse(true);
        buttonResizing.play();

    }
}
