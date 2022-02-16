package de.battleship.gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class BattleshipApp extends Application {
    private static Stage primaryStage;

    public static void main(String[] args) {
        launch(args);
    }

    public static Stage getPrimaryStage() {
        return primaryStage;
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        BattleshipApp.primaryStage = primaryStage;
        URL res = getClass().getResource("battleship.fxml");
        Parent root = FXMLLoader.load(res);

        primaryStage.setTitle("Battleship");
        primaryStage.setScene(new Scene(root, 790, 400));
        primaryStage.setResizable(false);
        primaryStage.show();
    }
}
