import java.math.BigInteger;
import static org.junit.Assert.*;
import org.junit.Test;

public class FibonacciTest {

    @Test
    public void testZero() {
        assertEquals(BigInteger.ZERO, Fibonacci.fibonacci(0));
    }

    @Test
    public void testOne() {
        assertEquals(BigInteger.ONE, Fibonacci.fibonacci(1));
    }

    @Test
    public void testTwo() {
        assertEquals(BigInteger.ONE, Fibonacci.fibonacci(2));
    }

    @Test
    public void testNegative() {
        assertEquals(BigInteger.ZERO, Fibonacci.fibonacci(-1));
    }

    @Test
    public void testOneHundred() {
        assertEquals(new BigInteger("354224848179261915075"), Fibonacci.fibonacci(100));
    }
    
}
