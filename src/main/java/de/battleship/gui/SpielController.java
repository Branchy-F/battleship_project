package de.battleship.gui;

import de.battleship.service.SpielFeldService;
import de.battleship.service.SpielFeldServiceImp;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ResourceBundle;

public class SpielController implements Initializable {
    private BattleshipApp battleshipApp;
    private SpielFeldService spielFeldService;

    public void setApp(BattleshipApp battleshipApp) {
        this.battleshipApp = battleshipApp;
    }
    public void setSpielFeldService(SpielFeldService spielFeldService) {
        this.spielFeldService = spielFeldService;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
