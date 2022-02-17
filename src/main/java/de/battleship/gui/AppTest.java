//package de.battleship.gui;
//
//
//import de.battleship.service.SpielFeldService;
//import de.battleship.service.SpielFeldServiceImp;
//import javafx.application.Application;
//import javafx.geometry.Insets;
//import javafx.geometry.Pos;
//import javafx.scene.Scene;
//import javafx.scene.control.Button;
//import javafx.scene.control.Label;
//import javafx.scene.layout.HBox;
//import javafx.scene.layout.VBox;
//import javafx.stage.Stage;
//
//import java.util.Arrays;
//
//public class AppTest extends Application {
//
//    static Stage primaryStage;
//    private SpielFeldService spielFeldService;
//    Label lAusgabe;
//    private int[][] feld = new int[10][10];
//    public static void main(String[] args) {
//        launch(args);
//    }
//
//    @Override
//    public void start(Stage primaryStage) {
//        this.primaryStage = primaryStage;
//        spielFeldService = new SpielFeldServiceImp(this);
//
//        VBox vBox = new VBox();
//        for (int j = 0; j < 10; j++){
//            HBox zeile = new HBox();
//            for (int i = 0; i < 10; i++){
//                Button b = new Button();
//                b.setMaxSize(30, 30);
//                b.setMinSize(30,30);
//                int x = j; int y = i;
//                b.setOnAction(e -> {
//                    teilEintragen(x, y, b);
//                });
//                zeile.getChildren().add(b);
//            }
//            vBox.getChildren().add(zeile);
//        }
//
//        lAusgabe = new Label("Tragen Sie"+
//                "\n 1 Schlachtschiff (4Kästchen)"+
//                "\n 2 Kreuzer (3 Kästchen)"+
//                "\n 3 Zerstörer (2 Kästchen)"+
//                "\n 4 U-Boote ein.");
//
//        HBox hbAusgabe = new HBox(lAusgabe);
//        hbAusgabe.setSpacing(10);
//        hbAusgabe.setPadding(new Insets(10));
//        hbAusgabe.setAlignment(Pos.CENTER_LEFT);
//
//        vBox.getChildren().add(hbAusgabe);
//
//        vBox.setPadding(new Insets(10));
//
//        Scene scene = new Scene(vBox, 320, 500);
//        primaryStage.setTitle("Schiffe");
//        primaryStage.setScene(scene);
//        primaryStage.show();
//    }
//
//
//    private void teilEintragen(int x, int y, Button b){
//        if (feld[x][y] == 0) {
//            feld[x][y] = 1;
//            b.setText("X");
//        }
//        else {
//            feld[x][y] = 0;
//            b.setText("");
//        }
//        spielFeldService.schiffeEintragen();
//    }
//    private void feldAusgeben() {
//        StringBuilder stringBuilder = new StringBuilder();
//        for (int[] ints : feld) {
//            String s = Arrays.toString(ints);
//            stringBuilder.append(s).append("\n");
//        }
//        lAusgabe.setText(stringBuilder.toString());
//    }
//
//    public void setMeldung(String meldung){
//        lAusgabe.setText(meldung);
//    }
//
//    public int[][] getFeld() {
//        return feld;
//    }
//
//    public void setFeld(int[][] feld) {
//        this.feld = feld;
//    }
//}
