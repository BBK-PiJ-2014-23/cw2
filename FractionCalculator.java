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
            String denum = "";
            boolean isDenum = false;
            for (int i = 0; i < inputString.length(); i++) {
                char currentChar = inputString.charAt(i);
                if (operator.equals("")) {
                    if (Character.isSpaceChar(currentChar)) {
                        if (!num.equals("")) {
                            fraction = fractionFromStrings(num, denum);
                            num = "";
                            denum = "";
                            isDenum = false;
                        }
                    } else if (Character.isDigit(currentChar) && !isDenum) {
                        num += currentChar;
                    } else if (Character.isDigit(currentChar) && isDenum) {
                        denum += currentChar;
                    } else if (inputString.charAt(i) == '/') {
                        if (i > 0 && Character.isDigit(inputString.charAt(i - 1))) {
                            isDenum = true;
                        } else {
                            operator = setOperator('/');
                        }
                    } else {
                        operator = setOperator(currentChar);
                    }
                }
            }
            if (!num.equals("")) {
                fraction = fractionFromStrings(num, denum);
                num = "";
                denum = "";
                isDenum = false;
            }
        }
        return fraction;
    }

    private Fraction fractionFromStrings(String num, String denum) {
        int numerator = Integer.parseInt(num);
        if (!denum.equals("")) {
            int denumerator = Integer.parseInt(denum);
            return new Fraction(numerator, denumerator);
        } else {
            return new Fraction(numerator, 1);
        }
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
