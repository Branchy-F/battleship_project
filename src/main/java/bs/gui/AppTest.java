package bs.gui;


import bs.service.SpielFeldServiceImp;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Arrays;

public class AppTest extends Application {

    static Stage primaryStage;
    private SpielFeldServiceImp spielFeldServiceImp;
    Label lAusgabe;
    Label lCheck;
    private int[][] feld = new int[10][10];
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;

        spielFeldServiceImp = new SpielFeldServiceImp();

        Button bAusgeben = new Button("Ausgeben");
        bAusgeben.setOnAction(e -> feldAusgeben());

        Button bCheckFeld = new Button("Check");
        bCheckFeld.setOnAction(e -> lCheck.setText(String.valueOf(spielFeldServiceImp.istValide(feld))));
        lCheck = new Label("");



        HBox hBoxCheck = new HBox(bCheckFeld, lCheck);
        hBoxCheck.setSpacing(10);
        hBoxCheck.setPadding(new Insets(10));
        hBoxCheck.setAlignment(Pos.CENTER_LEFT);


        VBox vBox = new VBox(hBoxCheck);
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
            vBox.getChildren().add(zeile);
        }

        lAusgabe = new Label("");
        vBox.getChildren().add(lAusgabe);

        Scene scene = new Scene(vBox, 300, 570);
        primaryStage.setTitle("Schiffe");
        primaryStage.setScene(scene);
        primaryStage.show();

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
    }
    private void feldAusgeben() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int[] ints : feld) {
            String s = Arrays.toString(ints);
            stringBuilder.append(s).append("\n");
        }
        lAusgabe.setText(stringBuilder.toString());
    }
}
