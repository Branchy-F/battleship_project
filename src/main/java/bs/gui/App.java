package bs.gui;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Accordion;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.util.Arrays;
import java.util.List;

public class App extends Application {

    static Stage primaryStage;
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        List<AppTabs> tabs = Arrays.asList(new Schiffe());

        Accordion root = new Accordion();
        for (AppTabs o : tabs) {
            HBox box = new HBox();
            box.getChildren().add(o.getRoot());
            TitledPane pane = new TitledPane(o.getName(), box);
            root.getPanes().add(pane);
        }

        Scene scene = new Scene(root, 300, 470);
        primaryStage.setTitle("Kundenverwaltung");
        primaryStage.setScene(scene);
        primaryStage.show();

    }
}
