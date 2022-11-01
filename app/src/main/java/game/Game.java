package game;

public class Game {
    String word;
    Integer attempts = 10;
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
                hiddenWord.append("_");
            }
        }
        return hiddenWord.toString();
    }

    public Integer getRemainingAttempts() {
        return attempts;
    }

}
