import org.example.Fraction;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class FractionTest {
    @Test
    void testAddition() {
        Fraction f1 = new Fraction(1, 2);
        Fraction f2 = new Fraction(1, 3);
        Fraction result = f1.add(f2);
        assertEquals(5, result.getNumerator());
        assertEquals(6, result.getDenominator());
    }

    @Test
    void testSubtraction() {
        Fraction f1 = new Fraction(3, 4);
        Fraction f2 = new Fraction(1, 4);
        Fraction result = f1.subtract(f2);
        assertEquals(1, result.getNumerator());
        assertEquals(2, result.getDenominator());
    }

    @Test
    void testMultiplication() {
        Fraction f1 = new Fraction(2, 3);
        Fraction f2 = new Fraction(3, 4);
        Fraction result = f1.multiply(f2);
        assertEquals(1, result.getNumerator());
        assertEquals(2, result.getDenominator());
    }

    @Test
    void testDivision() {
        Fraction f1 = new Fraction(3, 5);
        Fraction f2 = new Fraction(2, 7);
        Fraction result = f1.divide(f2);
        assertEquals(21, result.getNumerator());
        assertEquals(10, result.getDenominator());
    }

    @Test
    void testSimplification() {
        Fraction f = new Fraction(10, 20);
        assertEquals(1, f.getNumerator());
        assertEquals(2, f.getDenominator());
    }

    @Test
    void testDenominatorZero() {
        assertThrows(IllegalArgumentException.class, () -> new Fraction(1, 0));
    }
}
