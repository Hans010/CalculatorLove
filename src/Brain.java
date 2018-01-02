/**
 * Created by codecadet on 06/11/17.
 */
public class Brain {

    public double calculate(String arg1, String arg2, String operation) {

        String ar1 = arg1;
        String ar2 = arg2;
        double a = Double.parseDouble(arg1);
        System.out.println(a);
        double b = Double.parseDouble(arg2);

        switch (operation) {

            case "+":
                return a + b;
            case "-":
                return a - b;
            case "*":
                return a * b;
            case "/":
                return a / b;

        }

        return 0;
    }


}
