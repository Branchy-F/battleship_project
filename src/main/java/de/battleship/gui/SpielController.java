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

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
    public void setApp(BattleshipApp battleshipApp) {
        this.battleshipApp = battleshipApp;
    }

}
