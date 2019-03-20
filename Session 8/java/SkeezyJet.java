import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SkeezyJet {

    public static Boolean reachableDestination(String origin, String destination) {
        Map<String,ArrayList<String>> routeTable = validRoutes();
        return null;
    }

    private static Map<String,ArrayList<String>> validRoutes() {
        Map<String,ArrayList<String>> routes = new HashMap<>();
        // Planes depart ALC for CDG, LHR, LGW and JFK airports
        routes.put("ALC", new ArrayList<String>(Arrays.asList("CDG", "LHR", "LGW", "JFK")));
        routes.put("CDG", new ArrayList<String>(Arrays.asList("MAN", "LGW")));
        routes.put("JFK", new ArrayList<String>(Arrays.asList("SEA")));
        routes.put("LED", new ArrayList<String>(Arrays.asList("MAN", "ALC")));
        routes.put("LGW", new ArrayList<String>(Arrays.asList("ALC", "LED", "CDG")));
        routes.put("LHR", new ArrayList<String>());
        routes.put("LC7", new ArrayList<String>(Arrays.asList("LGW", "ALC")));
        routes.put("MAN", new ArrayList<String>(Arrays.asList("CDG")));
        routes.put("SEA", new ArrayList<String>(Arrays.asList("LC7")));
        routes.put("STD", new ArrayList<String>(Arrays.asList("YYZ")));
        routes.put("YYZ", new ArrayList<String>(Arrays.asList("STD")));
        return routes;
    }
}
