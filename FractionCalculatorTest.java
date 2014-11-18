public class FractionCalculatorTest {

    public static void main (String[] args) {
        FractionCalculator calc = new FractionCalculator();
        
        calc.setState(new Fraction(1, 3));
        calc.setOperator("+");

        calc.reset();
        test(calc.getState(),new Fraction(1, 3),"error state rest test 1");
        test(calc.getState(),new Fraction(0, 1),"error state rest test 2");
        test(calc.getOperator(),"+","error operator reset test 1");
        test(calc.getOperator(),"","error operator reset test 2");

    }

    static void test(Fraction f1, Fraction f2, String msg){
        if (! f1.equals(f2))
            System.out.println(msg);
    }
    
    static void test(String str1, String str2, String msg){
        if (! str1.equals(str2))
            System.out.println(msg);
    }
}