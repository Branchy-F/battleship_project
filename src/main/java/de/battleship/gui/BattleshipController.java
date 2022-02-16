package de.battleship.gui;

import javafx.event.ActionEvent;

import java.io.IOException;

public class BattleshipController {
    private BattleshipApp battleshipApp;
    public void setApp(BattleshipApp battleshipApp) {
        this.battleshipApp = battleshipApp;
    }
    public void zweitesFensterOeffnen(ActionEvent actionEvent) {
        try { battleshipApp.zweitesFensterOeffnen(); } catch (IOException e) { e.printStackTrace();}
    }
}
