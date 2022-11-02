package game;

import java.util.ArrayList;

public class Game {
    private String word;
    private String guessedWord;
    private Integer attempts = 10;
    private ArrayList<Character> guessedLetters = new ArrayList<Character>();

    private Masker encryptor;

    public Game(WordChoser choser, Masker masker) {
        word = choser.getRandomWordFromDictionary();
        encryptor = masker;
        guessedWord = encryptor.getsMaskedWord(word, getGuessedLetters());
    }

    public String getWordToGuess() {
        return guessedWord;
    }

    public void updateGuessedWord() {guessedWord = encryptor.getsMaskedWord(word, getGuessedLetters());}

    public Integer getRemainingAttempts() {
        return attempts;
    }

    public Boolean guessLetter(Character letter) {
        if (word.indexOf(letter) != -1) {
            guessedLetters.add(letter);
            updateGuessedWord();
            return true;
        } else {
            attempts -= 1;
            return false;
        }
    }

    public ArrayList getGuessedLetters() {
        return guessedLetters;
    }

    public Boolean isGameLost() {
        if (getRemainingAttempts() > 0) {
            return false;
        } else {
            return true;
        }
    }

    public Boolean isGameWon() {
        if (guessedWord.equals(word)) {
            return true;
        } else {
            return false;
        }
    }
}
