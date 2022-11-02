package game;

import static org.junit.Assert.*;
import org.junit.Test;
import java.util.ArrayList;

public class MaskerTest {
    @Test public void testGetsMaskedWord() {
        Masker masker = new Masker();
        ArrayList<Character> guessedLetters = new ArrayList<Character>();
        guessedLetters.add('E');
        guessedLetters.add('V');

        assertEquals("Gets masked word", "DEVE___E_", masker.getsMaskedWord("DEVELOPER", guessedLetters));
    }

}
