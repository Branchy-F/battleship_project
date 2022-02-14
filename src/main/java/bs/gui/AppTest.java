package bs.gui;


import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class AppTest extends Application {

    static Stage primaryStage;
    Label lCheck;
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;

        Button bCheckVerbindung = new Button("Verbinden");
        bCheckVerbindung.setOnAction(e -> checkVerbindung());
        lCheck = new Label("Test");
        HBox hBoxCheck = new HBox(bCheckVerbindung,lCheck);
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
                zeile.getChildren().add(b);
            }
            vBox.getChildren().add(zeile);
        }

        Scene scene = new Scene(vBox, 300, 470);
        primaryStage.setTitle("Schiffe");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    private void checkVerbindung() {

    }
}
