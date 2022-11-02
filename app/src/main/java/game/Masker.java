package game;

import java.util.ArrayList;

public class Masker {
    public String getsMaskedWord(String word, ArrayList<Character> guesses) {
        StringBuilder hiddenWord = new StringBuilder();
        for (int i = 0; i < word.length(); i++ ) {
            Character currentLetter = word.charAt(i);
            if (i == 0) {
                hiddenWord.append(currentLetter);
            } else {
                if (guesses.indexOf(currentLetter) != -1) {
                    hiddenWord.append(currentLetter);
                } else {
                    hiddenWord.append("_");
                }
            }
        }
        return hiddenWord.toString();
    }
}
