import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class TaylorSeriesTest {

    @ParameterizedTest
    @CsvSource(value = {
            "0, 1",
            "1, 1",
            "2, 2",
            "3, 6",
            "4, 24",
            "5, 120",
            "12, 479001600"
    }, ignoreLeadingAndTrailingWhitespace = true)
    public void testFactorial(int n, int result) {
        assertEquals(result, TaylorSeries.factorial(n));
        assertThrows(ArithmeticException.class, ()-> {TaylorSeries.factorial(-1);});
    }

    @ParameterizedTest
    @CsvSource(value = {
            "0, 0, 1",
            "1, 0, 1",
            "2, 1, 2",
            "10, 5, 252",
            "25, 7, 480700"
    }, ignoreLeadingAndTrailingWhitespace = true)
    public void testComb(int n, int k, int result) {
        assertEquals(result, TaylorSeries.comb(n,k));
    }

    @ParameterizedTest
    @CsvSource(value = {
            "0, 1",
            "1, 0",
            "2, -1",
            "4, 5",
            "10, -50521"
    }, ignoreLeadingAndTrailingWhitespace = true)
    public void testEulerNumbers(int n, int result) {
        assertThrows(ArithmeticException.class, () -> TaylorSeries.eulerNumber(-1));
        assertEquals(result, TaylorSeries.eulerNumber(n));
    }

    @ParameterizedTest
    @ValueSource(doubles = {-1.1, 0, 1, 1.1, 3, -3, 6.2})
    public void testSec(double x) {
        int steps = 16;
        double accuracy = 0.0001;

        double y = TaylorSeries.sec(x, steps);
        double real = 1 / Math.cos(x);
        double diff = Math.abs(y - real);
        assertTrue(diff <= accuracy);
    }

}
