import java.lang.String;
import java.util.*;

public class Redactor {

    public static String redact(String sentence, List<String> badwords) {
        List<String> output = new ArrayList<String>();
        for (String word: Arrays.asList(sentence.split(" "))) {
                if (badwords.contains(word.toLowerCase())) {
                  output.add("****");
                }
                else {
                        output.add(word);
                }
        }
        return String.join(" ", output);
    }
}
