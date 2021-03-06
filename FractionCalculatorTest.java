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
        //         test(calc.evaluate(new Fraction(1, 3),"/ /"), new Fraction(0, 1), "error double operator test 2");
        //         test(calc.evaluate(new Fraction(1, 3)," 23/2 / /"), new Fraction(0, 1), "error double operator test 3");
        //         test(calc.evaluate(new Fraction(1, 3),"23/2 //"), new Fraction(0, 1), "error double operator test 4");
        //         test(calc.evaluate(new Fraction(1, 3),"// 23/2"), new Fraction(0, 1), "error double operator test 5");
        //         test(calc.evaluate(new Fraction(1, 3),"// 23/2 + 2/3"), new Fraction(0, 1), "error double operator test 6");

        calc.reset();
        test(calc.evaluate(new Fraction(1, 3),"3/2 * 3/2"), new Fraction(1, 3), "error multiplication test 1");
        test(calc.evaluate(new Fraction(1, 3),"3/2 * 3/2"), new Fraction(9, 4), "error multiplication test 2");
        test(calc.evaluate(new Fraction(0, 1),"* 3/2"), new Fraction(0, 1), "error multiplication test 3");
        test(calc.evaluate(new Fraction(1, 3),"* 3/2"), new Fraction(3, 6), "error multiplication test 4");
        test(calc.evaluate(new Fraction(0, 1),"3/2 * 3/2 * 3/2 "), new Fraction(27, 8), "error multiplication test 5");

        calc.reset();
        test(calc.evaluate(new Fraction(1, 3),"3/2 / 3/2"), new Fraction(3, 2), "error division test 1");
        test(calc.evaluate(new Fraction(1, 3),"3/2 / 3/2"), new Fraction(1, 1), "error division test 2");
        test(calc.evaluate(new Fraction(0, 1),"/ 3/2"), new Fraction(0, 1), "error division test 3");
        test(calc.evaluate(new Fraction(1, 3),"/ 3/2"), new Fraction(2, 9), "error division test 4");
        test(calc.evaluate(new Fraction(0, 1),"1/2 / 1/2 / 1/2"), new Fraction(4, 2), "error division test 5");

        calc.reset();
        test(calc.evaluate(new Fraction(1, 3),"3/2 + 3/2"), new Fraction(1, 3), "error addition test 1");
        test(calc.evaluate(new Fraction(1, 3),"3/2 + 3/4"), new Fraction(9, 4), "error addition test 2");
        test(calc.evaluate(new Fraction(0, 1),"+ 3/2"), new Fraction(3, 2), "error addition test 3");
        test(calc.evaluate(new Fraction(1, 3),"+ 3/2"), new Fraction(11, 6), "error addition test 4");
        test(calc.evaluate(new Fraction(0, 1),"1/2 + 1/2 + 1/3"), new Fraction(8, 6), "error addition test 5");

        calc.reset();   
        test(calc.evaluate(new Fraction(1, 3),"3/2 - 3/2"), new Fraction(1, 3), "error subtraction test 1");
        test(calc.evaluate(new Fraction(1, 3),"3/2 - 3/4"), new Fraction(3, 4), "error subtraction test 2");
        test(calc.evaluate(new Fraction(0, 1),"- 3/2"), new Fraction(-3, 2), "error subtraction test 3");
        test(calc.evaluate(new Fraction(1, 3),"- 3/2"), new Fraction(-7, 6), "error subtraction test 4");
        test(calc.evaluate(new Fraction(0, 1),"1/2 - 1/2 - 1/3"), new Fraction(-1, 3), "error subtraction test 5");

        calc.reset();
        test(calc.evaluate(new Fraction(1, 3),"d"), new Fraction(1, 3), "error invalid input test 1");
        //         test(calc.evaluate(new Fraction(1, 3),"d"), new Fraction(0, 1), "error invalid input test 2");
        //         test(calc.evaluate(new Fraction(1, 3),"4 d"), new Fraction(0, 1), "error invalid input test 3");
        //         test(calc.evaluate(new Fraction(1, 3),"4 + 4 + d"), new Fraction(0, 1), "error invalid input test 4");
        //         test(calc.evaluate(new Fraction(1, 3),"5 + d"), new Fraction(0, 1), "error invalid input test 5");
        
        calc.reset();
        test(calc.evaluate(new Fraction(1, 3),"3/4 + 1/-3 * 7 / 5"), new Fraction(1, 3), "error mega test 1");
        test(calc.evaluate(new Fraction(1, 3),"3/4 + 1/-3 * 7 / 5"), new Fraction(35, 60), "error mega test 2");
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