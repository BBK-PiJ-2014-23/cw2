public class FractionCalculatorTest {

    public static void main (String[] args) {
        FractionCalculator calc = new FractionCalculator();

        calc.setState(new Fraction(1, 3));
        calc.setOperator("+");

        calc.reset();
        test(calc.getState(),new Fraction(1, 3),"error state reset test 1");
        test(calc.getState(),new Fraction(0, 1),"error state reset test 2");
        test(calc.getOperator(),"+","error operator reset test 1");
        test(calc.getOperator(),"","error operator reset test 2");

        calc.reset();
        test(calc.evaluate(new Fraction(-1, 3),"a"),new Fraction(-1, 3),"error absolute value test 1");
        test(calc.evaluate(new Fraction(-1, 3),"a"),new Fraction(1, 3),"error absolute value test 2");
        test(calc.evaluate(new Fraction(1, -3),"a"),new Fraction(1, 3),"error absolute value test 3");
        test(calc.evaluate(new Fraction(1, -3),"A"),new Fraction(1, 3),"error absolute value test 4");
        test(calc.evaluate(new Fraction(1, -3),"abs"),new Fraction(1, 3),"error absolute value test 5");

        calc.reset();
        test(calc.evaluate(new Fraction(-1, 3),"n"),new Fraction(-1, 3),"error negate value test 1");
        test(calc.evaluate(new Fraction(-1, 3),"n"),new Fraction(1, 3),"error negate value test 2");
        test(calc.evaluate(new Fraction(1, -3),"n"),new Fraction(1, 3),"error negate value test 3");
        test(calc.evaluate(new Fraction(-1, -3),"n"),new Fraction(-1, 3),"error negate value test 4");
        test(calc.evaluate(new Fraction(1, -3),"N"),new Fraction(1, 3),"error negate value test 5");
        test(calc.evaluate(new Fraction(1, -3),"neg"),new Fraction(1, 3),"error negate value test 6");

        calc.reset();
        test(calc.evaluate(new Fraction(1, 3),"c"),new Fraction(1, 3),"error clear value test 1");
        test(calc.evaluate(new Fraction(1, 3),"c"),new Fraction(0, 1),"error clear value test 2");
        test(calc.evaluate(new Fraction(1, 3),"C"),new Fraction(0, 1),"error clear value test 3");
        test(calc.evaluate(new Fraction(1, 3),"clear"),new Fraction(0, 1),"error clear value test 4");

        calc.reset();
        test(calc.evaluate(new Fraction(1, 3),""),new Fraction(1, 3),"error empty input test");
        
        calc.reset();
        test(calc.evaluate(new Fraction(1, 3),"23"),new Fraction(1, 3),"error single int test 1");
        test(calc.evaluate(new Fraction(1, 3),"23"),new Fraction(23, 1),"error single int test 2");
        test(calc.evaluate(new Fraction(1, 3),"23 "),new Fraction(23, 1),"error single int test 3");
        test(calc.evaluate(new Fraction(1, 3)," 23"),new Fraction(23, 1),"error single int test 4");
        test(calc.evaluate(new Fraction(1, 3),"23 5"),new Fraction(5, 1),"error single int test 5");
        test(calc.evaluate(new Fraction(1, 3),"23/5 /"),new Fraction(23, 5),"error single int test 6");
        
        calc.reset();
        test(calc.evaluate(new Fraction(1, 3),"23/2"),new Fraction(1, 3),"error single fraction test 1");
        test(calc.evaluate(new Fraction(1, 3),"23/2"),new Fraction(23, 2),"error single fraction test 2");
        test(calc.evaluate(new Fraction(1, 3)," 23/2"),new Fraction(23, 2),"error single fraction test 3");
        test(calc.evaluate(new Fraction(1, 3),"23/2 "),new Fraction(23, 2),"error single fraction test 4");
        test(calc.evaluate(new Fraction(1, 3),"23/2 5/4"),new Fraction(5, 4),"error single fraction test 5");
        test(calc.evaluate(new Fraction(1, 3),"23/2 /"),new Fraction(23, 2),"error single fraction test 5");
        
        calc.reset();
        test(calc.evaluate(new Fraction(1, 3),"//"), new Fraction(1, 3), "error double operator test 1");
        test(calc.evaluate(new Fraction(1, 3),"/ /"), new Fraction(0, 1), "error double operator test 2");
        test(calc.evaluate(new Fraction(1, 3)," 23/2 / /"), new Fraction(0, 1), "error double operator test 3");
        test(calc.evaluate(new Fraction(1, 3),"23/2 //"), new Fraction(0, 1), "error double operator test 4");
        test(calc.evaluate(new Fraction(1, 3),"// 23/2"), new Fraction(0, 1), "error double operator test 5");
        test(calc.evaluate(new Fraction(1, 3),"// 23/2 + 2/3"), new Fraction(0, 1), "error double operator test 5");
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