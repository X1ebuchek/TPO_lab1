import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TaylorSeriesTest {

    @Test
    public void testFactorial() {
        assertEquals(1, TaylorSeries.factorial(0));
        assertEquals(1, TaylorSeries.factorial(1));
        assertEquals(2, TaylorSeries.factorial(2));
        assertEquals(6, TaylorSeries.factorial(3));
        assertEquals(24, TaylorSeries.factorial(4));
        assertEquals(120, TaylorSeries.factorial(5));
        assertEquals(479001600, TaylorSeries.factorial(12));
        assertThrows(ArithmeticException.class, ()-> {TaylorSeries.factorial(-1);});
    }

    @Test
    public void testComb() {
        assertEquals(1, TaylorSeries.comb(0,0));
        assertEquals(1, TaylorSeries.comb(1,0));
        assertEquals(2, TaylorSeries.comb(2,1));
        assertEquals(252, TaylorSeries.comb(10,5));
        assertEquals(480700, TaylorSeries.comb(25,7));
    }

    @Test
    public void testEulerNumbers() {
        assertThrows(ArithmeticException.class, () -> TaylorSeries.eulerNumber(-1));
        assertEquals(1, TaylorSeries.eulerNumber(0));
        assertEquals(0, TaylorSeries.eulerNumber(1));
        assertEquals(-1, TaylorSeries.eulerNumber(2));
        assertEquals(5, TaylorSeries.eulerNumber(4));
        assertEquals(-50521, TaylorSeries.eulerNumber(10));

    }

    @Test
    public void testSec() {
        int steps = 16;
        double accuracy = 0.0001;
        for (double x = -1.1; x <= 1; x += 0.01) {
            double y = TaylorSeries.sec(x, steps);
            double real = 1 / Math.cos(x);
            double diff = Math.abs(y - real);
            System.out.println("diff = " + diff);
            assertTrue(diff <= accuracy);
        }
    }

}
