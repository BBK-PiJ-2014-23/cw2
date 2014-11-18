public class FractionCalculatorTest {

    public static void main (String[] args) {
        FractionCalculator calc = new FractionCalculator();
        calc.statePrint();

        calc.setState(new Fraction(1, 3));
        calc.setOperator("+");
        calc.statePrint();
        
        calc.reset();
        calc.statePrint();

    }

    
}