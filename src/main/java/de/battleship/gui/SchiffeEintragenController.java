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

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SchiffeEintragenController implements Initializable {
    @FXML
    private VBox vbFeldEintragen;
    @FXML
    private Label lMeldung;
    private SpielFeldService spielFeldService;
    private int[][] feld = new int[10][10];
    private BattleshipApp battleshipApp;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        spielFeldErstellen();
    }

    public void setApp(BattleshipApp battleshipApp) {
        this.battleshipApp = battleshipApp;
    }

    private void spielFeldErstellen() {
        lMeldung.setText("Zweites Fenster");
        spielFeldService = new SpielFeldServiceImp(this);

        for (int j = 0; j < 10; j++){
            HBox zeile = new HBox();
            for (int i = 0; i < 10; i++){
                Button b = new Button();
                b.setMaxSize(30, 30);
                b.setMinSize(30,30);
                int x = j; int y = i;
                b.setOnAction(e -> {
                    teilEintragen(x, y, b);
                });
                zeile.getChildren().add(b);
            }
            vbFeldEintragen.getChildren().add(zeile);
        }

        setMeldung("Tragen Sie"+
                "\n 1 Schlachtschiff (4Kästchen)"+
                "\n 2 Kreuzer (3 Kästchen)"+
                "\n 3 Zerstörer (2 Kästchen)"+
                "\n 4 U-Boote ein.");
    }


    public int[][] getFeld() {
        return feld;
    }

    public void setMeldung(String meldung) {
        lMeldung.setText(meldung);
    }

    private void teilEintragen(int x, int y, Button b){
        if (feld[x][y] == 0) {
            feld[x][y] = 1;
            b.setText("X");
        }
        else {
            feld[x][y] = 0;
            b.setText("");
        }
        if (spielFeldService.schiffeEintragen()){
            try { battleshipApp.spielFensterOeffnen(); } catch (IOException e) { e.printStackTrace(); }
        }
    }
}
