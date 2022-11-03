package game;

import java.util.ArrayList;

public class Game {
    private String word;
    private String guessedWord;

    private String playerName = "";
    private Integer attempts = 10;
    private ArrayList<Character> guessedLetters = new ArrayList<Character>();

    private Masker encryptor;

    public Game(WordChoser choser, Masker masker, String name) {
        word = choser.getRandomWordFromDictionary();
        encryptor = masker;
        guessedWord = encryptor.getsMaskedWord(word, getGuessedLetters());
        playerName = name;
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

    public ArrayList<Character> getGuessedLetters() {
        return guessedLetters;
    }

    public Boolean isGameLost() {
        return getRemainingAttempts() > 0 ? false : true;
    }

    public Boolean isGameWon() {
        return guessedWord.equals(word) ? true : false;
    }

    public String getName() {
        return playerName;
    }
}
