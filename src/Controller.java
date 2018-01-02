import javafx.event.EventHandler;
import javafx.scene.control.TextField;

public class Controller {

    private UserInterface ui;
    private Brain brain = new Brain();

    public Controller (UserInterface userInterface) {

        ui = userInterface;
    }

    private String argument = "0";
    private String argument2 = "0";
    private String operation = "";

    private Boolean isResult = false;


    public void checkValue(String value) {

        if (value.equals("+") || value.equals("-") || value.equals("*") || value.equals("/")) {

            argument = ui.getText();
            ui.setText("0");
            operation = value;

        } else if (value.equals("C")) {

            argument = "0";
            operation = "";
            isResult = false;
            ui.setText("0");

        } else if (value.equals("=")) {

            if (!isResult) {
                argument2 = ui.getText();
            }
            String result = String.valueOf(brain.calculate(argument, argument2, operation));
            ui.setText(result);
            argument = result;
            isResult = true;
            System.out.println("a1 " + argument + " a2 " + argument2 + " result" + result);

        } else {

            if (ui.getText().equals("0") || (isResult)) {
                ui.setText(value);
                isResult = false;
            } else {
                ui.setText(ui.getText() + value);
            }
        }


    }


}
