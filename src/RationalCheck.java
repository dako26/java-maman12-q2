public class RationalCheck {
    public static void main(String[] args) {
        // Test constructor with valid input
        Rational rational1 = new Rational(1, 2);
        System.out.println("Constructor (valid input): PASS");

        // Test constructor with denominator zero
        try {
            Rational invalidRational = new Rational(1, 0);
            System.out.println("Constructor (denominator zero): FAIL");
        } catch (IllegalArgumentException e) {
            System.out.println("Constructor (denominator zero): PASS");
        }

        // Test getter methods
        if (rational1.getNumerator() == 1 && rational1.getDenominator() == 2) {
            System.out.println("Getter Methods: PASS");
        } else {
            System.out.println("Getter Methods: FAIL");
        }

        // Test comparison methods
        Rational rational2 = new Rational(3, 4);
        if (!rational1.graterThen(rational2) && !rational1.equalsRational(rational2)) {
            System.out.println("Comparison Methods: PASS");
        } else {
            System.out.println("Comparison Methods: FAIL");
        }

        // Test arithmetic operations
        Rational additionResult = rational1.plus(rational2);
        Rational subtractionResult = rational1.minus(rational2);
        Rational multiplicationResult = rational1.multiply(rational2);
        Rational divisionResult = rational1.divide(rational2);

        // Check if arithmetic operations yield expected results
        if (additionResult.equalsRational(new Rational(5, 4)) &&
                subtractionResult.equalsRational(new Rational(-1, 4)) &&
                multiplicationResult.equalsRational(new Rational(3, 8)) &&
                divisionResult.equalsRational(new Rational(2, 3))) {
            System.out.println("Arithmetic Operations: PASS");
        } else {
            System.out.println("Arithmetic Operations: FAIL");
        }

        // Test reduction method
        Rational reducedRational = rational1.reduce();
        if (reducedRational.equalsRational(new Rational(1, 2))) {
            System.out.println("Reduction Method: PASS");
        } else {
            System.out.println("Reduction Method: FAIL");
        }
    }
}