package bs.gui;

import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class Schiffe extends AppTabs {

    public Node getRoot() {


        VBox vBox = new VBox();
        for (int j = 0; j < 10; j++){
            HBox zeile = new HBox();
            for (int i = 0; i < 10; i++){
                Button b = new Button();
                b.setMaxSize(10, 10);
                zeile.getChildren().add(b);
            }
            vBox.getChildren().add(zeile);
        }
        return vBox;
    }

    @Override
    public String getName() {
        return "Schiffe";
    }
}
