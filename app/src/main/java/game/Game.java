package game;

public class Game {
    private String word;
    public Game(String word) {
        this.word = word;
    }

    public String getWordToGuess() {
        StringBuilder hiddenWord = new StringBuilder();
        for (Integer i = 0; i < this.word.length(); i++ ) {
            Character currentLetter = this.word.charAt(i);
            if (i == 0) {
                hiddenWord.append(currentLetter);
            } else {
                hiddenWord.append("_");
            }
        }
        return hiddenWord.toString();
    }
}
