package de.battleship.gui;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class App extends Application {

    static Stage window;
    Button button;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("BATTLESHIP");
        button = new Button("Spiel starten");

        button.setOnAction(e -> SpielFeld.display());

        StackPane layout = new StackPane();
        layout.getChildren().add(button);
        Scene scene = new Scene(layout, 300, 250);

        window.setScene(scene);
        window.show();
    }
}
