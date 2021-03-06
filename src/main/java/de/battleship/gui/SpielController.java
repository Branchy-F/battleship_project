package de.battleship.gui;

import de.battleship.service.SpielFeldService;
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


    @FXML
    private Label lSpielmeldung;
    @FXML
    private Label lAntwort;
    @FXML
    private VBox vbMeinFeld;
    @FXML
    private VBox vbGegnerFeld;
    

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        for (int j = 0; j < 10; j++){
            HBox zeile = new HBox();
            for (int i = 0; i < 10; i++){
                Button b = new Button();
                b.setMaxSize(30, 30);
                b.setMinSize(30,30);
                b.setStyle("-fx-border-color: grey;");
                int x = j; int y = i;
                b.setOnAction(e ->  spielFeldService.zugAbschicken(x, y));
                zeile.getChildren().add(b);
            }
            vbGegnerFeld.getChildren().add(zeile);
        }
    }

    public void setlSpielmeldung(String meldung) { this.lSpielmeldung.setText(meldung); }
    public void setAntwort(String antwort) { this.lAntwort.setText(antwort); }


    public void setMeinFeld(int[][] meinFeld) {
        for (int j = 0; j < 10; j++){
            HBox zeile = new HBox();
            for (int i = 0; i < 10; i++){
                Label b = new Label();
                b.setMaxSize(30, 30);
                b.setMinSize(30,30);

                if(meinFeld[j][i] == 0){ b.setStyle("-fx-border-color: grey; -fx-background-color: #e5e5e5;"); }
                if(meinFeld[j][i] == 1){ b.setStyle("-fx-border-color: grey; -fx-background-color: black;"); }

                zeile.getChildren().add(b);
            }
            vbMeinFeld.getChildren().add(zeile);
        }
    }
    
    public void setGegnerFeldmeinZug(int[][] gegnerFeld) {
        for (int j = 0; j < 10; j++){
            HBox zeile = new HBox();
            for (int i = 0; i < 10; i++){
                Button b = new Button();
                if(gegnerFeld[j][i] == 0){ b.setStyle("-fx-border-color: grey; -fx-background-color: #e5e5e5;"); }
                if(gegnerFeld[j][i] == 1){ b.setStyle("-fx-border-color: grey; -fx-background-color: black;"); }
                b.setMaxSize(30, 30);
                b.setMinSize(30,30);
                zeile.getChildren().add(b);
            }
            vbGegnerFeld.getChildren().add(zeile);
        }
        lSpielmeldung.setText("Dein Zug");
    }

    public void setGegnerFeldGegnerZug(int[][] gegnerFeld) {
        for (int j = 0; j < 10; j++){
            HBox zeile = new HBox();
            for (int i = 0; i < 10; i++){
                Label b = new Label();
                if(gegnerFeld[j][i] == 0){ b.setStyle("-fx-border-color: grey; -fx-background-color: #e5e5e5;"); }
                if(gegnerFeld[j][i] == 1){ b.setStyle("-fx-border-color: grey; -fx-background-color: black;"); }
                b.setMaxSize(30, 30);
                b.setMinSize(30,30);
                zeile.getChildren().add(b);
            }
            vbGegnerFeld.getChildren().add(zeile);
        }
        lSpielmeldung.setText("Warte aug Gegner");
    }

    public void VerbindungErstellen(ActionEvent actionEvent) {
//        spielFeldService.verbindungErstellen();
    }
}
