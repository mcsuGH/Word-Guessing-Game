package game;

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Arrays;

public class WordChoserTest {
    @Test public void testGetRandomWord() {
        WordChoser wordChoser = new WordChoser();
        String[] MOCK_DICT = {"MAKERS", "CANDIES", "DEVELOPER", "LONDON"};

        assertTrue(Arrays.asList(MOCK_DICT).contains(wordChoser.getRandomWordFromDictionary()));
    }
}
