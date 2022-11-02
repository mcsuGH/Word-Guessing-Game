package game;

import java.util.ArrayList;

public class Game {
    private String word;
    private Integer attempts = 10;
    private ArrayList<Character> guessedLetters = new ArrayList<Character>();
    public Game(WordChoser choser) {
        word = choser.getRandomWordFromDictionary();
    }

    public String getWordToGuess() {
        StringBuilder hiddenWord = new StringBuilder();
        for (int i = 0; i < word.length(); i++ ) {
            Character currentLetter = word.charAt(i);
            if (i == 0) {
                hiddenWord.append(currentLetter);
            } else {
                if (guessedLetters.indexOf(currentLetter) != -1) {
                    hiddenWord.append(currentLetter);
                } else {
                    hiddenWord.append("_");
                }
            }
        }
        return hiddenWord.toString();
    }

    public Integer getRemainingAttempts() {
        return attempts;
    }

    public Boolean guessLetter(Character letter) {
        if (word.indexOf(letter) != -1) {
            guessedLetters.add(letter);
            return true;
        } else {
            attempts -= 1;
            return false;
        }
    }

    public ArrayList getGuessedLetters() {
        return guessedLetters;
    }
}
