package de.battleship.gui;

import javafx.event.ActionEvent;

public class BattleshipController {

    private BattleshipApp battleshipApp;
    public void setApp(BattleshipApp battleshipApp) {
        this.battleshipApp = battleshipApp;
    }

    public void zweitesFensterOeffnen(ActionEvent actionEvent) {
        battleshipApp.zweitesFensterOeffnen();
    }
}
