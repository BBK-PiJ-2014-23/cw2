/**
 * Created by keith for the second coursework assignment.
 */
public class FractionTest {
    public static void main(String[] args) {

        // test divide by zero - should print an error and exit
        new Fraction(1, 0);
        // test multiply
        Fraction f = new Fraction(3,10);
        Fraction g = new Fraction(1,2);
        Fraction h = new Fraction(3,5);
        if (!f.equals(g.multiply(h))) System.out.println("Multiply failed");
        // test equals
        test(new Fraction(1, 2),new Fraction(1, 2),"error test 1");
        test(new Fraction(1, 2),new Fraction(3, 6),"error test 2");
        test(new Fraction(-1, 2),new Fraction(1, -2),"error test 3");
        test(new Fraction(-1, -2),new Fraction(1, 2),"error test 4");
        test(new Fraction(4, -8),new Fraction(1, 2),"error test 5");

        // test add
        test(new Fraction(1, 2).add(new Fraction(1, 2)), new Fraction(2, 2),"error addition test 1");
        test(new Fraction(3, 5).add(new Fraction(2, 4)), new Fraction(22, 20),"error addition test 2");
        test(new Fraction(2, 4).add(new Fraction(3, 5)), new Fraction(22, 20),"error addition test 3");
        test(new Fraction(2, 5).add(new Fraction(2, -5)), new Fraction(0, 5),"error addition test 4");
        test(new Fraction(6, 5).add(new Fraction(2, 4)), new Fraction(7, 5),"error addition test 5");
        
        // test subtract
        test(new Fraction(2, 2).subtract(new Fraction(1, 2)), new Fraction(1, 2),"error subtraction test 1");
        test(new Fraction(3, 5).subtract(new Fraction(2, 4)), new Fraction(2, 20),"error subtraction test 2");
        test(new Fraction(2, 4).subtract(new Fraction(3, 5)), new Fraction(-2, 20),"error subtraction test 3");
        test(new Fraction(2, 5).subtract(new Fraction(2, -5)), new Fraction(4, 5),"error subtraction test 4");
        test(new Fraction(6, 5).subtract(new Fraction(2, 4)), new Fraction(7, 5),"error subtraction test 5");
        
        // test divide
        test(new Fraction(2, 2).divide(new Fraction(1, 2)), new Fraction(4, 2),"error division test 1");
        test(new Fraction(3, 5).divide(new Fraction(2, 4)), new Fraction(12, 10),"error division test 2");
        test(new Fraction(2, 4).divide(new Fraction(3, 5)), new Fraction(10, 12),"error division test 3");
        test(new Fraction(2, 5).divide(new Fraction(2, -5)), new Fraction(-10, 10),"error division test 4");
        test(new Fraction(6, 5).divide(new Fraction(2, 4)), new Fraction(7, 5),"error division test 5");
        
        // test absValue
        test(new Fraction(2, 2).absValue(), new Fraction(2, 2),"error absoluteValue test 1");
        test(new Fraction(-3, 5).absValue(), new Fraction(3, 5),"error absoluteValue test 2");
        test(new Fraction(2, -4).absValue(), new Fraction(2, 4),"error absoluteValue test 3");
        test(new Fraction(-2, -5).absValue(), new Fraction(2, 5),"error absoluteValue test 4");
        test(new Fraction(-2, 2).absValue(), new Fraction(-2, 2),"error absoluteValue test 5");
    }

    static void test(Fraction f1, Fraction f2, String msg){
        if (! f1.equals(f2))
            System.out.println(msg);
    }
}
