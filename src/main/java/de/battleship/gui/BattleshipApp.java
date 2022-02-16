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
        primaryStage.setScene(new Scene(root));
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public void zweitesFensterOeffnen() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("schiffeEintragen.fxml"));
        Parent root = loader.load();
        SchiffeEintragenController controller = loader.getController();
        controller.setApp(this);

        primaryStage.setTitle("Schiffe eintragen");
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public void spielFensterOeffnen() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("spiel.fxml"));
        Parent root = loader.load();
        SpielController controller = loader.getController();
        controller.setApp(this);

        primaryStage.setTitle("Spiel");
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.setResizable(false);
        primaryStage.show();
    }
}
