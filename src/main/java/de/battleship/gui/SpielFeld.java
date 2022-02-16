package de.battleship.gui;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.awt.*;

public class SpielFeld {

    public static void display()  {
        App.window.setTitle("BATTLESHIP");
        App.window.setMinWidth(300);
        Label label = new Label();
        label.setText("");


        VBox layout = new VBox(10);
        layout.getChildren().addAll();
        layout.setAlignment(Pos.CENTER);
        Scene scene = new Scene(layout);
        App.window.setScene(scene);
        App.window.show();
    }

}
