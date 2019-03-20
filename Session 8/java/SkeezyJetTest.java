import java.util.List;
import java.util.Arrays;
import static org.junit.Assert.*;
import org.junit.Test;

public class SkeezyJetTest {

    @Test
    public void testNowhereNowhere() {
        assertEquals(false, SkeezyJet.reachableDestination("",""));
    }

    @Test
    public void testHeathrowNowhere() {
        assertEquals(false, SkeezyJet.reachableDestination("LHR",""));
    }
    
    @Test
    public void testNowhereLeningrad() {
        assertEquals(false, SkeezyJet.reachableDestination("","LED"));
    }

    @Test
    public void testGatwickLeningrad() {
        assertEquals(true, SkeezyJet.reachableDestination("LGW","LED"));
    }

    @Test
    public void testManchesterLeningrad() {
        assertEquals(true, SkeezyJet.reachableDestination("MAN","LED"));
    }

    @Test
    public void testHeathrowLeningrad() {
        assertEquals(false, SkeezyJet.reachableDestination("LHR","LED"));
    }


    @Test
    public void testStansteadLeningrad() {
        assertEquals(false, SkeezyJet.reachableDestination("STD","LED"));
    }

    @Test
    public void testTorontoLeningrad() {
        assertEquals(false, SkeezyJet.reachableDestination("YYZ","LED"));
    }

    @Test
    public void testHeathrowLunarCitySeven() {
        assertEquals(false, SkeezyJet.reachableDestination("LHR","LC7"));
    }

    @Test
    public void testLeedsBradfordLunarCitySeven() {
        assertEquals(false, SkeezyJet.reachableDestination("LBA","LC7"));
    }

    @Test
    public void testSeattleManchester() {
        assertEquals(false, SkeezyJet.reachableDestination("SEA","MAN"));
    }

    @Test
    public void testManchesterLunarCitySeven() {
        assertEquals(false, SkeezyJet.reachableDestination("MAN", "LC7"));
    }
  
}