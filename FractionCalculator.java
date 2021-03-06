import java.util.*;

public class FractionCalculator {

    public static void main(String[] args) {
        FractionCalculator calc = new FractionCalculator();
        calc.reset();
        Scanner sc = new Scanner(System.in);
        boolean finished = false;

        System.out.println("Welcome to Stefan E. Mayer's calculator");
        while (!finished) {
            System.out.println("Current state: " + calc.getState().toString());
            System.out.println("Current operator: " + calc.getOperator());
            System.out.print("Input: ");
            if (sc.hasNext()) {
                String input = sc.nextLine();
                if (input.equals("q") || input.equals("Q") || input.equals("quit")) {
                    finished = true;
                } else {
                    calc.setState(calc.evaluate(calc.getState(), input));
                }
            } else {
                System.out.println("Goodbye");
                finished = true;
            }
        }
    }

    private Fraction state;
    private String operator;

    public FractionCalculator() {
        Fraction state = new Fraction(0, 1);
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
        state = new Fraction(0, 1);
        setOperator("");
    }

    public Fraction evaluate(Fraction fraction, String inputString) {
        if (inputString.equals("a") || inputString.equals("A") || inputString.equals("abs")) {
            fraction = fraction.absValue();
        } else if (inputString.equals("n") || inputString.equals("N") || inputString.equals("neg")) {
            fraction = fraction.negate();
        } else if (inputString.equals("c") || inputString.equals("C") || inputString.equals("clear")) {
            fraction = new Fraction(0, 1);
        } else {
            String num = "";
            String denom = "";
            boolean isDenom = false;
            boolean isValidInput = true;
            int i = 0;
            while (isValidInput && i < inputString.length()) {
                char currentChar = inputString.charAt(i);
                if (Character.isDigit(currentChar) && !isDenom) {
                    num += currentChar;
                } else if (Character.isDigit(currentChar) && isDenom) {
                    denom += currentChar;
                } else if (!Character.isSpaceChar(currentChar)) {
                    if (i > 0 && currentChar == '/' && Character.isDigit(inputString.charAt(i - 1))) {
                        isDenom = true;
                    } else if (i < inputString.length() - 1 && currentChar == '-' && Character.isDigit(inputString.charAt(i + 1))) {
                        if (isDenom) {
                            denom += "-";
                        } else {
                            num += "-";
                        }
                    } else if (operator.equals("") && (currentChar == '*' || currentChar == '/' || currentChar == '+' || currentChar == '-')) {
                        operator = setOperator(currentChar);
                    } else {
                        System.out.println("Error");
                        fraction = new Fraction(0, 1);
                        num = "";
                        denom = "";
                        isDenom = false;
                        operator = "";
                        isValidInput = false;
                    }
                }

                if (Character.isSpaceChar(currentChar) || i == inputString.length() - 1) {
                    if (!num.equals("")) {
                        Fraction f = fractionFromStrings(num, denom);
                        if (operator.equals("")) {
                            fraction = f;
                        } else if (operator.equals("*")) {
                            fraction = fraction.multiply(f);
                        } else if (operator.equals("/")) {
                            fraction = fraction.divide(f);
                        } else if (operator.equals("+")) {
                            fraction = fraction.add(f);
                        } else if (operator.equals("-")) {
                            fraction = fraction.subtract(f);
                        }
                        operator = "";
                        num = "";
                        denom = "";
                        isDenom = false;
                    }
                }
                i++;
            }
        }
        return fraction;
    }

    private Fraction fractionFromStrings(String num, String denom) {
        int numerator = Integer.parseInt(num);
        if (!denom.equals("")) {
            int denomerator = Integer.parseInt(denom);
            return new Fraction(numerator, denomerator);
        } else {
            return new Fraction(numerator, 1);
        }
    }

    private String setOperator(char operator) {
        return Character.toString(operator);
    }
}
