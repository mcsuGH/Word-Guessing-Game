package game;

import java.util.Random;

public class Game {
    private String word;
    private Integer remainingAttempts;
    public Game() {
        word = getRandomWordFromDictionary();
        remainingAttempts = 10;
    }

    public static final String[] DICTIONARY = {"MAKERS", "CANDIES", "DEVELOPER", "LONDON"};

    public String getWordToGuess() {
        StringBuilder hiddenWord = new StringBuilder();
        for (int i = 0; i < word.length(); i++ ) {
            Character currentLetter = word.charAt(i);
            if (i == 0) {
                hiddenWord.append(currentLetter);
            } else {
                hiddenWord.append("_");
            }
        }
        return hiddenWord.toString();
    }

    public Integer getRemainingAttempts() {
        return remainingAttempts;
    }

    public String getRandomWordFromDictionary() {
        Random rand = new Random();
        return DICTIONARY[rand.nextInt(DICTIONARY.length)];
    }
}
