import java.lang.String;
import java.util.regex.*;

public class Palindrome {

    public static Boolean is_palindrome(String sentence) {
        sentence = sentence
          .replaceAll("\\.", "")
          .replaceAll("[^A-Za-z0-9]+", "")
          .toLowerCase();
        System.out.println(sentence);
        if (sentence.length() == 0) {
            return false;
        }
        else {
            for (int i=0; i < ((sentence.length() / 2)); i++ ) {
                if (sentence.charAt(i) != sentence.charAt(sentence.length() -i -1)) {
                    return false;
                }
            }
        }
        return true;
    }
}