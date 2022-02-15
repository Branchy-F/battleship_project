package de.battleship.gui;
import javafx.scene.control.Button;
import javafx.scene.layout.*;


public class PaneOrganizer {


    private BorderPane main;

    public PaneOrganizer() {
        main = new BorderPane();
        main.setStyle("-fx-background-color: grey;");
        main.setPrefHeight(500);
        main.setPrefWidth(500);
        createGrid();
        createsecGrid();

    }

    private void createGrid() {
        GridPane playerGrid = new GridPane();
        for (int i = 0; i<10;i++) {
            playerGrid.getColumnConstraints().add(new ColumnConstraints(20));
            playerGrid.getRowConstraints().add(new RowConstraints(20));
        }
        for (int i = 0; i<10;i++) {
            for (int j=0;j<10;j++) {
                Button button = new Button();
                button.setPrefHeight(20);
                button.setPrefWidth(20);

                GridPane.setConstraints(button, j, i);
                playerGrid.getChildren().add(button);
            }
        }
        main.getChildren().add(playerGrid);
    }

    private void createsecGrid() {
        GridPane playerGrid = new GridPane();
        for (int i = 0; i<10;i++) {
            playerGrid.getColumnConstraints().add(new ColumnConstraints(20));
            playerGrid.getRowConstraints().add(new RowConstraints(20));
        }
        for (int i = 0; i<10;i++) {
            for (int j=0;j<10;j++) {
                Button button = new Button();
                button.setPrefHeight(20);
                button.setPrefWidth(20);

                GridPane.setConstraints(button, j, i);
                playerGrid.getChildren().add(button);
            }
        }
        main.getChildren().add(playerGrid);
    }

    public Pane getRoot() {
        return main;
    }


}
