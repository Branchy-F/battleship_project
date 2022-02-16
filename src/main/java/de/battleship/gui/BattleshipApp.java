package de.battleship.gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class BattleshipApp extends Application {
    private static Stage primaryStage;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        BattleshipApp.primaryStage = primaryStage;

        FXMLLoader loader = new FXMLLoader(getClass().getResource("battleship.fxml"));
        Parent root = loader.load();
        BattleshipController controller = loader.getController();
        controller.setApp(this);

        primaryStage.setTitle("Battleship");
        primaryStage.setScene(new Scene(root, 790, 400));
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public void zweitesFensterOeffnen() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("schiffeEintragen.fxml"));
        Parent root = null;
        try {
            root = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        primaryStage.setTitle("Schiffe eintragen");
        primaryStage.setScene(new Scene(root, 400, 400));
        primaryStage.setResizable(false);
        primaryStage.show();
    }
}
