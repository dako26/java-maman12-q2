public class Rational {
    private int numerator;
    private int denominator;

    public Rational(int numerator, int denominator) {
        this.numerator = numerator;
        if (denominator == 0)
            throw new IllegalArgumentException("denominator cannot be zero");
        this.denominator = denominator;
    }

    public int getNumerator() {
        return numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    public boolean graterThen(Rational other) {
        return numerator * other.getDenominator() > other.getNumerator() * denominator;
    }

    public boolean equalsRational(Rational other) {
        return numerator * other.getDenominator() == other.getNumerator() * denominator;
    }


    public Rational plus(Rational other) {
        return new Rational(((numerator * other.getDenominator()) + (denominator * other.getNumerator())), (denominator * other.getDenominator()));
    }

    public Rational minus(Rational other) {
        return new Rational(((numerator * other.getDenominator()) - (denominator * other.getNumerator())), (denominator * other.getDenominator()));
    }

    public Rational multiply(Rational other) {
        return new Rational((numerator * other.getNumerator()), (denominator * other.getDenominator()));
    }

    public Rational divide(Rational other) {

        if (other.getNumerator() == 0) {
            throw new ArithmeticException("division by zero");
        }
        return new Rational((numerator * other.getDenominator()), (denominator * other.getNumerator()));
    }

    @Override
    public String toString() {
        return numerator + "/" + denominator;
    }

    public Rational reduce() {
        int gcd = findGCD(Math.abs(numerator), Math.abs(denominator));
        int reducedNumerator = numerator / gcd;
        int reducedDenominator = denominator / gcd;
        if (reducedDenominator < 0) { // Ensure the denominator is positive
            reducedNumerator = -reducedNumerator;
            reducedDenominator = -reducedDenominator;
        }
        return new Rational(reducedNumerator, reducedDenominator);
    }

    private int findGCD(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}



