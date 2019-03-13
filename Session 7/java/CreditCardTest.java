import java.util.List;
import java.util.Arrays;
import static org.junit.Assert.*;
import org.junit.Test;

public class CreditCardTest {

    @Test
    public void testEmpty() {
        assertEquals(false, CreditCard.validate(""));
    }

    @Test
    public void testZero() {
        assertEquals(true, CreditCard.validate("0"));
    }

    @Test
    public void testVisa() {
        assertEquals(true, CreditCard.validate("4743903107345687"));
    }

    @Test
    public void testVisaNoNines() {
        assertEquals(true, CreditCard.validate("4743803307345687"));
    }

    @Test
    public void testMasterCard() {
        assertEquals(true, CreditCard.validate("5490745468338088"));
    }

    @Test
    public void testAmEx() {
        assertEquals(true, CreditCard.validate("343539069275686"));
    }
    
    @Test
    public void testNotValid() {
        assertEquals(false, CreditCard.validate("4123412341234123"));
    }
}
