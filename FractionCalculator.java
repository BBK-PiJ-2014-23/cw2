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
        String operator = "";
        if (inputString.equals("a") || inputString.equals("A") || inputString.equals("abs")) {
            fraction = fraction.absValue();
        } else if (inputString.equals("n") || inputString.equals("N") || inputString.equals("neg")) {
            fraction = fraction.negate();
        } else if (inputString.equals("c") || inputString.equals("C") || inputString.equals("clear")) {
            fraction = new Fraction(0, 1);
        } else {
            String num = "";
            boolean isFraction = false;
            for (int i = 0; i < inputString.length(); i++) {
                char currentChar = inputString.charAt(i);
                if (operator.equals("")) {
                    if (Character.isSpaceChar(currentChar)) {
                        if (num.length() > 0) {
                            fraction = fractionFromStrings(num);
                            num = "";
                            isFraction = false;
                        }
                    } else if (Character.isDigit(currentChar)) {
                        num += currentChar;
                    } else if (inputString.charAt(i) == '/') {
                        if (i > 0 && Character.isDigit(inputString.charAt(i - 1))) {
                            isFraction = true;
                        } else {
                            operator = setOperator('/');
                        }
                    } else {
                        operator = setOperator(currentChar);
                    }
                }
            }
            if (num.length() > 0) {
                fraction = fractionFromStrings(num);
            }
        }
        return fraction;
    }

    private Fraction fractionFromStrings(String num) {
        int numerator = Integer.parseInt(num);
        return new Fraction(numerator, 1);
    }

    private String setOperator(char operator) {
        return Character.toString(operator);
    }

    public void statePrint() {
        System.out.println("State: " + getState());
        System.out.println("Operator: " + getOperator());
        System.out.println();
    }
}
