/**
 * Created by keith for the second coursework assignment.
 */
public class Fraction {
    private int numerator;
    private int denominator;

    public Fraction(int num, int denom) {
        if (denom == 0) {
            System.out.println("Invalid fraction with denominator 0"); 
            // this should use exceptions
            return;
        }
        int gcd = myGcd(num, denom);
        setNumerator(num / gcd);
        setDenominator(denom / gcd);
    }

    @Override
    public String toString() {
        if (getDenominator() == 1) {
            return "" + getNumerator();
        } else {
            return "" + getNumerator() + '/' + getDenominator();
        }
    }

    public int getNumerator() {
        return numerator;
    }

    public void setNumerator(int num) {
        numerator = num;
    }

    public int getDenominator() {
        return denominator;
    }

    public void setDenominator(int num) {
        denominator = num;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Fraction fraction = (Fraction) o;

        if (getDenominator() != fraction.getDenominator()) return false;
        if (getNumerator() != fraction.getNumerator()) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = numerator;
        result = 31 * result + denominator;
        return result;
    }

    public Fraction multiply(Fraction other) {

        int num = this.getNumerator() * other.getNumerator();
        int denom = this.getDenominator() * other.getDenominator();
        return new Fraction(num, denom);
    }

    public Fraction divide(Fraction other) {

        int num = this.getNumerator() * other.getDenominator();
        int denom = this.getDenominator() * other.getNumerator();
        return new Fraction(num, denom);
    }

    public Fraction add(Fraction other) {
        int num1 = this.getNumerator();
        int denom1 = this.getDenominator();
        int num2 = other.getNumerator();
        int denom2 = other.getDenominator();

        if (denom1 != denom2) {
            int[] commonDenomsAdjustedNums = getCommonDenomsAdjustedNums(num1, denom1, num2, denom2);
            num1 = commonDenomsAdjustedNums[0];
            denom1 = commonDenomsAdjustedNums[1];
            num2 = commonDenomsAdjustedNums[2];
            denom2 = commonDenomsAdjustedNums[3];
        }
        return new Fraction(num1 + num2, denom1); // irrelevant which denominator to insert, they are the same.
    }

    public Fraction subtract(Fraction other) {
        int num1 = this.getNumerator();
        int denom1 = this.getDenominator();
        int num2 = other.getNumerator();
        int denom2 = other.getDenominator();

        if (denom1 != denom2) {
            int[] commonDenomsAdjustedNums = getCommonDenomsAdjustedNums(num1, denom1, num2, denom2);
            num1 = commonDenomsAdjustedNums[0];
            denom1 = commonDenomsAdjustedNums[1];
            num2 = commonDenomsAdjustedNums[2];
            denom2 = commonDenomsAdjustedNums[3];
        }
        return new Fraction(num1 - num2, denom1); // irrelevant which denominator to insert, they are the same.
    }

    public Fraction absValue() {
        int num = Math.abs(getNumerator());
        int denom = Math.abs(getDenominator());
        return new Fraction(num, denom);
    }

    public Fraction negate() {
        int num = getNumerator();
        int denom = getDenominator();
        if (num > 0 && denom > 0 || num < 0 && denom < 0) {
            return new Fraction(num * (-1), denom);
        } else {
            return absValue();
        }
    }

    private int myGcd(int a, int b) {
        while (b != 0) {
            int t = b;
            b = a % b;
            a = t;
        }
        return a;
    }

    private int[] getCommonDenomsAdjustedNums(int num1, int denom1, int num2, int denom2) {

        // Moving a minus from denominator to nominator if neccesary.
        if (denom1 < 0) {
            num1 *= -1;
            denom1 *= -1;
        }
        if (denom2 < 0) {
            num2 *= -1;
            denom2 *= -1;
        }

        // Finding common denominator
        int multiplicator1 = 1;
        int multiplicator2 = 1;
        int initDenom1 = denom1;
        while (denom1 % denom2 != 0) {
            denom1 += initDenom1;
            multiplicator1++;
        }
        multiplicator2 = denom1 / denom2;

        // Adjusting all values
        num1 *= multiplicator1; // denom1 is already adjusted
        num2 *= multiplicator2;
        denom2 *= multiplicator2;
        int[] commonDenomsAdjustedNums = {num1, denom1, num2, denom2};
        return commonDenomsAdjustedNums;
    }
}
