package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setTitle("Calculator Love");

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.TOP_CENTER);

        grid.setHgap(1);
        grid.setVgap(1);

        // 25px grid padding all around
        grid.setPadding(new Insets(1,1,1,1));

        String[] buttons = {"7", "8", "9", "+", "4", "5", "6", "-", "1", "2", "3", "*", "C", "0", "=", "/"};

        for (int i = 0; i < buttons.length; i++) {

            int row = 0;
            int col = i;
            while (col > 4) {
                col-=4
            }

            Button b = new Button(buttons[i]);
            grid.add(b, col, row, 1, 1);

        }


        primaryStage.setScene(new Scene(grid, 300, 275));
        primaryStage.show();
    }



    public static void main(String[] args) {
        launch(args);
    }
}
