import java.util.List;
import static org.junit.Assert.*;
import org.junit.Test;

public class PalindromeTest {

    @Test
    public void testEmpty() {
        String sentence = "";
        assertEquals(false, Palindrome.is_palindrome(sentence));
    }

    @Test
    public void testOxo() {
        String sentence = "oxo";
        assertEquals(true, Palindrome.is_palindrome(sentence));
    }

    @Test
    public void testPanama() {
        String sentence = "A Man, A Plan, a Canal: Panama!";
        assertEquals(true, Palindrome.is_palindrome(sentence));
    }

    @Test
    public void testElba() {
        String sentence = "Able was I, ere I saw Elba 😁";
        assertEquals(true, Palindrome.is_palindrome(sentence));
    }

    @Test
    public void testSeven() {
        String sentence = "seven";
        assertEquals(false, Palindrome.is_palindrome(sentence));
    }

    @Test
    public void testNights() {
        String sentence = "1001N? 1001!";
        assertEquals(true, Palindrome.is_palindrome(sentence));
    }

    @Test
    public void testNonPrint() {
        String sentence = "race\ncar";
        assertEquals(true, Palindrome.is_palindrome(sentence));
    }

    @Test
    public void testEmoji() {
        String sentence = "(.)_(.)";
        assertEquals(false, Palindrome.is_palindrome(sentence));
    }

    @Test
    public void testInvertedSmiley() {
        String sentence = "|_^_|";
        assertEquals(false, Palindrome.is_palindrome(sentence));
    }
}
