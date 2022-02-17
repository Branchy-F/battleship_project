package de.battleship.gui;

import de.battleship.service.SpielFeldService;
import de.battleship.service.SpielFeldServiceImp;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class BattleshipApp extends Application {
    private static Stage primaryStage;
    private SpielFeldService spielFeldService;
    SchiffeEintragenController schiffeEintragenController;
    BattleshipController battleshipController;
    SpielController spielController;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        spielFeldService = new SpielFeldServiceImp(this);
        BattleshipApp.primaryStage = primaryStage;

        FXMLLoader loader = new FXMLLoader(getClass().getResource("battleship.fxml"));
        Parent root = loader.load();
        battleshipController = loader.getController();
        battleshipController.setApp(this);

        primaryStage.setTitle("Battleship");
        primaryStage.setScene(new Scene(root));
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public void zweitesFensterOeffnen() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("schiffeEintragen.fxml"));
        Parent root = loader.load();
        schiffeEintragenController = loader.getController();
        schiffeEintragenController.setApp(this);
        schiffeEintragenController.setSpielFeldService(spielFeldService);

        primaryStage.setTitle("Schiffe eintragen");
        primaryStage.setScene(new Scene(root, 650, 400));
        primaryStage.sizeToScene();
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public void spielFensterOeffnen() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("spiel.fxml"));
        Parent root = loader.load();
        spielController = loader.getController();
        spielController.setApp(this);
        spielController.setSpielFeldService(spielFeldService);

        primaryStage.setTitle("Spiel");
        primaryStage.setScene(new Scene(root, 670, 430));
        primaryStage.sizeToScene();
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public int[][] getFeld() { return schiffeEintragenController.getFeld(); }

    public void setMeldung(String meldung) { schiffeEintragenController.setMeldung(meldung); }

    public void setSpielmeldung(String meldung) {
        spielController.setlSpielmeldung(meldung);
    }

    public void setMeinFeld(int[][] meinFeld) {
        spielController.setMeinFeld(meinFeld);
    }
}
