import java.lang.String;
import java.util.*;
import java.util.stream.Collectors;

public class Redactor {

    public static String redact1(String sentence, List<String> badwords) {
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

    public static String redact2(String sentence, List<String> badwords) {
        return Arrays.asList(sentence.split(" ")).stream()
               .map(word -> badwords.contains(word.toLowerCase()) ? "****" : word)
               .collect(Collectors.joining(" "));
    }
}
