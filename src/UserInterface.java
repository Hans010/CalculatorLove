import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * Created by codecadet on 07/11/17.
 */
public class UserInterface {

    private Stage stage;
    private TextField ui;
    private Controller controller;

    private final int MIN_SIDE= 50;

    public UserInterface(Stage stage) {

        this.stage = stage;
        controller = new Controller(this);
    }

    public void setUi() {

        ui = new TextField();
        ui.getStyleClass().add("display");
        ui.setFont(Font.font("Helvetica Neue", 28));


        stage.setTitle("Calculator Love");

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.TOP_CENTER);

        grid.setHgap(0);
        grid.setVgap(0);

        // 25px grid padding all around
        grid.setPadding(new Insets(0, 0,0,0));

        // Screen

        ui.setMinHeight(50);
        ui.setAlignment(Pos.CENTER_RIGHT);
        grid.add(ui, 0, 0, 4, 1);
        // ui.insertText();

        // Keys
        String[] buttons = {"7", "8", "9", "+", "4", "5", "6", "-", "1", "2", "3", "*", "C", "0", "=", "/"};

        int row = 2;
        // int col = 0;


        EventHandler<ActionEvent> handler = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                controller.checkValue(((Button) event.getSource()).getText());

            }
        };

        for (int i = 0; i < buttons.length; i++) {

            if (i > 0 && i % 4 == 0) {
                // col -= 4;
                row++;
            }

            Button b = new Button(buttons[i]);
            if (i % 4 == 3) {
                b.getStyleClass().add("operators");
            } else {
                b.getStyleClass().add("buttons");
            }
            b.setOnAction(handler);

            b.setMinSize(MIN_SIDE, MIN_SIDE);
            b.setFont(Font.font("Helvetica Neue", 20));
            grid.add(b, i % 4, row, 1, 1);

            //col++;
            ui.setText("0");
        }

        Scene scene = new Scene(grid, 201, 250);
        scene.getStylesheets().add("/pimpMyCalculatorLove.css");
        stage.setScene(scene);
        stage.show();
    }

    public void setText(String value) {
        ui.setText(value);
    }

    public String getText() {
        return ui.getText();
    }

}

