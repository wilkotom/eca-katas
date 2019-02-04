import java.util.List;
import static org.junit.Assert.*;
import org.junit.Test;

public class PreT9DecoderTest {

    @Test
    public void testEmpty() {
        String keypresses = "";
        String message = "";
        assertEquals(message, PreT9Decoder.decode(keypresses));
    }

    @Test
    public void testSos() {
        String keypresses = "77776667777";
        String message = "SOS";
        assertEquals(message, PreT9Decoder.decode(keypresses));
    }


    @Test
    public void testMistakenKeypresses() {
        String keypresses = "222220002";
        String message = "A A";
        assertEquals(message, PreT9Decoder.decode(keypresses));
    }

    @Test
    public void testNumber() {
        String keypresses = "4444";
        String message = "4";
        assertEquals(message, PreT9Decoder.decode(keypresses));
    }
 
    @Test
    public void testABC() {
        String keypresses = "2 22 222";
        String message = "ABC";
        assertEquals(message, PreT9Decoder.decode(keypresses));
    }

    @Test
    public void testWhatIfXKCD75() {
        String keypresses = "66 666 66 6 666 66 666426 666887777";
        String message = "NONMONOGAMOUS";
        assertEquals(message, PreT9Decoder.decode(keypresses));
    }

    @Test
    public void testFullSentence() {
        String keypresses = "9996668802777330877727 733 304446602062999933033388555 55506663330477788337777";
        String message = "YOU ARE TRAPPED IN A MAZE FULL OF GRUES";
        assertEquals(message, PreT9Decoder.decode(keypresses));
    }

    @Test
    public void testMultiSpaces() {
        String keypresses = "0 0";
        String message = "  ";
        assertEquals(message, PreT9Decoder.decode(keypresses));
    }

    @Test
    public void testZero() {
        String keypresses = "00";
        String message = "0";
        assertEquals(message, PreT9Decoder.decode(keypresses));
    }

    @Test
    public void testOne() {
        String keypresses = "1";
        String message = "1";
        assertEquals(message, PreT9Decoder.decode(keypresses));
    }

    @Test
    public void testLongPause() {
        String keypresses = "555666   66407288       777733";
        String message = "LONG PAUSE";
        assertEquals(message, PreT9Decoder.decode(keypresses));
    }

    @Test
    public void testPauseBeforeStarting() {
        String keypresses = "   728877773302233 3336667773307777827778444664";
        String message = "PAUSE BEFORE STARTING";
        assertEquals(message, PreT9Decoder.decode(keypresses));
    }
}
