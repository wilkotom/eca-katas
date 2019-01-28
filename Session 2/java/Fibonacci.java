import java.math.BigInteger;

public class Fibonacci {

    public static BigInteger fibonaccix(long n) {
        BigInteger a = BigInteger.ZERO;
        BigInteger b = BigInteger.ONE;
        BigInteger c = BigInteger.ZERO;
        n = (n > 0) ? n : 0;
        while (n > 0) {
            c = a.add(b);
            a = b;
            b = c;
            n = n - 1;
        }
        return a;

    }

    public static BigInteger fibonacci(long n) {
        return fibonacci(n, BigInteger.ZERO, BigInteger.ONE);
    }

    private static BigInteger fibonacci(long n, BigInteger a, BigInteger b) {
        if (n <= 0){
            return a;
        }
        else {
            return fibonacci(n -1, b, a.add(b));
        }
    }

}
