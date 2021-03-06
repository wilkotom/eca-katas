import java.lang.String;
import java.util.HashMap;
import java.util.Map;

public class PreT9Decoder {

    public static String decode(String keypresses) {
        Map<String,String> lookUpTable = lookUpTable();
        return "This is not the message you are looking for";
    }


    private static Map<String, String> lookUpTable() {
        Map<String,String> lookups = new HashMap<String,String>();
        lookups.put("1", "1");
        lookups.put("2", "ABC2");
        lookups.put("3", "DEF3");
        lookups.put("4", "GHI4");
        lookups.put("5", "JKL5");
        lookups.put("6", "MNO6");
        lookups.put("7", "PQRS7");
        lookups.put("8", "TUV8");
        lookups.put("9", "WXYZ9");
        lookups.put("0", " 0");
        lookups.put("", "");
        return lookups;
    }


}
