import java.util.*;

public class FractionCalculator {
    private Fraction state;
    private String operator;

    public FractionCalculator() {
        state = new Fraction(0, 1);
        operator = "";
    }

    public void setState(Fraction fraction) {
        state = fraction;
    }

    public Fraction getState() {
        return state;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getOperator() {
        return operator;
    }

    public void reset() {
        setState(new Fraction(0, 1));
        setOperator("");
    }

    public Fraction evaluate(Fraction fraction, String inputString) {
        if (inputString.equals("a") || inputString.equals("A") || inputString.equals("abs")) {
            fraction = fraction.absValue();
        } else if (inputString.equals("n") || inputString.equals("N") || inputString.equals("neg")) {
            fraction = fraction.negate();
        } else if (inputString.equals("c") || inputString.equals("C") || inputString.equals("clear")) {
            fraction = new Fraction(0, 1);
        }
        return fraction;
    }

    public void statePrint() {
        System.out.println("State: " + getState());
        System.out.println("Operator: " + getOperator());
        System.out.println();
    }
}