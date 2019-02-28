import java.util.List;
import static org.junit.Assert.*;
import org.junit.Test;

public class ScrabbleTest {

    @Test
    public void testEmpty() {
        String sentence = "";
        assertEquals(0, Scrabble.score(sentence));
    }

    @Test
    public void testExpedia() {
        String sentence = "Expedia";
        assertEquals(0, Scrabble.score(sentence));
    }

    @Test
    public void testSyzygy() {
        String sentence = "Syzygy";
        assertEquals(25, Scrabble.score(sentence));
    }

    @Test
    public void testHexangular() {
        String sentence = "Hexangular";
        assertEquals(0, Scrabble.score(sentence));
    }

    @Test
    public void testLect() {
        String sentence = "Lect";
        assertEquals(0, Scrabble.score(sentence));
    }

    @Test
    public void testIonizer() {
        String sentence = "Ionizer";
        assertEquals(66, Scrabble.score(sentence));
    }

    @Test
    public void testJezebel() {
        String sentence = "Jezebel";
        assertEquals(0, Scrabble.score(sentence));
    }

    @Test
    public void testBoom() {
        String sentence = "Boom!";
        assertEquals(0, Scrabble.score(sentence));
    }
}
