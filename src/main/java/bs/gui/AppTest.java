package bs.gui;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class AppTest extends Application {

    static Stage primaryStage;
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;

        VBox vBox = new VBox();
        for (int j = 0; j < 10; j++){
            HBox zeile = new HBox();
            for (int i = 0; i < 10; i++){
                Button b = new Button();
                b.setMaxSize(30, 30);
                b.setMinSize(30,30);
                zeile.getChildren().add(b);
            }
            vBox.getChildren().add(zeile);
        }

        Scene scene = new Scene(vBox, 300, 470);
        primaryStage.setTitle("Schiffe");
        primaryStage.setScene(scene);
        primaryStage.show();

    }
}
