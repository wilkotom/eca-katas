import java.lang.String;
import java.io.*;
import java.nio.file.Files;
import java.nio.charset.*;
import java.util.*;
import java.util.regex.*;

public class Scrabble {

    public static int score(String word) {
        int score = 0;
        Map<String, Integer> scores = letterScores();
        List<String> validWords = new ArrayList<String>();
        Boolean isValidWord = false; 
        word = word.toLowerCase();
        if (word.matches(".*[^a-z].*") || word.length() > 7) {
            return 0;
        }
        try {
            Scanner inFile = new Scanner(new File("./words.txt"));
            while(inFile.hasNext()) {
                String newWord = inFile.nextLine();
                if (newWord.equals(word)) {
                    isValidWord = true;
                    break;
                }
            }
        }
        catch(FileNotFoundException e) {
            return 0;
        }
        if (!isValidWord) {
            return 0;
        }
        for (String letter : word.split("")) {
            score += scores.get(letter);
        }
        if (word.length() == 7) {
            score += 50;
        }
        return(score);
    }

    public static int score1(String word) {
        Map<String, Integer> scores = letterScores();
        final String cleanWord = word.toLowerCase().replaceAll("[^a-z]+", "");
        List<String> validWords;
        try {
            validWords = Files.readAllLines(new File("./words.txt").toPath(), Charset.defaultCharset());       
            int score = (cleanWord.length() == word.length() && cleanWord.length() <= 7) ? 
                Arrays.asList(cleanWord.split("")).stream()
                .map(x -> scores.get(x))
                .reduce(0, (x,y) -> x+y) : 0;
            if (validWords.stream().anyMatch(x -> x.trim().equals(cleanWord))){
                return(score + ((word.length() == 7) ? 50 : 0));
            }
        }
        catch(Exception e) {
            // Nasty dirty hack - IOException for File not found, and NullPointerException when input is empty
        }
        return 0;
    }

    private static Map<String, Integer> letterScores() {
        Map<String, Integer> scores = new HashMap<String, Integer>();
        scores.put("a", 1);
        scores.put("b", 3);
        scores.put("c", 3);
        scores.put("d", 2);
        scores.put("e", 1);
        scores.put("f", 4);
        scores.put("g", 2);
        scores.put("h", 4);
        scores.put("i", 1);
        scores.put("j", 8);
        scores.put("k", 5);
        scores.put("l", 1);
        scores.put("m", 3);
        scores.put("n", 1);
        scores.put("o", 1);
        scores.put("p", 3);
        scores.put("q", 10);
        scores.put("r", 1);
        scores.put("s", 1);
        scores.put("t", 1);
        scores.put("u", 1);
        scores.put("v", 4);
        scores.put("w", 4);
        scores.put("x", 8);
        scores.put("y", 4);
        scores.put("z", 10);
        return scores;
    }
}
