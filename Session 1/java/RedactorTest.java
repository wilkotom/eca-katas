import java.util.List;
import static org.junit.Assert.*;
import org.junit.Test;

public class RedactorTest {

    @Test
    public void testFlamingo() {
        String sentence = "The Press Secretary's codename is Flamingo";
        List<String> badwords = Arrays.aslist("flamingo", "eagle");
        assertEquals("The Press Secretary's codename is ****", Redactor(sentence, badwords);
    }

    @Test
    public void testFlamingoAndEagle() {
        String sentence = "The Press Secretary's codename is Flamingo";
        List<String> badwords = Arrays.aslist("flamingo", "eagle");
        assertEquals("**** and **** are meeting at 11:00", Redactor(sentence, badwords);
    }


    @Test
    public void testTwoFlamingos() {
        String sentence = "The Press Secretary's codename is Flamingo";
        List<String> badwords = Arrays.aslist("flamingo", "eagle");
        assertEquals("**** hates that her codename is ****", Redactor(sentence, badwords);
    }

    @Test
    public void testNoMatch() {
        String sentence = "The weather has been clement for the time of year";
        List<String> badwords = Arrays.aslist("flamingo", "eagle");
        assertEquals("The weather has been clement for the time of year", Redactor(sentence, badwords);
    }

    @Test
    public void testEmptyList() {
        String sentence = "Though I hear of a storm due to hit us later";
        List<String> badwords = Arrays.aslist();
        assertEquals("Though I hear of a storm due to hit us later", Redactor(sentence, badwords);
    }

    @Test
    public void testSubstring() {
        String sentence = "Flamingoland was my local theme park growing up";
        List<String> badwords = Arrays.aslist("flamingo", "eagle");
        assertEquals("Flamingoland was my local theme park growing up", Redactor(sentence, badwords);
    }

    @Test
    public void testEmptySentence() {
        String sentence = "";
        List<String> badwords = Arrays.aslist("flamingo", "eagle");
        assertEquals("", Redactor(sentence, badwords);
    }

    @Test
    public void testEmptyInput() {
        String sentence = "";
        List<String> badwords = Arrays.aslist();
        assertEquals("", Redactor(sentence, badwords);
    }

}
