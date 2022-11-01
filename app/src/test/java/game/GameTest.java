package game;

import static org.junit.Assert.*;
import org.junit.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class GameTest {
    @Test public void testGetsWordToGuess() {
        WordChoser mockChoser = mock(WordChoser.class);
        when(mockChoser.getRandomWordFromDictionary()).thenReturn("MAKERS");

        Game game = new Game(mockChoser);
        assertEquals("Game initialises with random word", "M_____", game.getWordToGuess());
    }

    @Test public void testGetsWordToGuess2() {
        WordChoser mockChoser = mock(WordChoser.class);
        when(mockChoser.getRandomWordFromDictionary()).thenReturn("DEVELOPER");

        Game game = new Game(mockChoser);
        assertEquals("Game initialises with random word", "D________", game.getWordToGuess());
    }

    @Test public void testGetsInitialRemainingAttempts() {
        WordChoser mockChoser = mock(WordChoser.class);
        when(mockChoser.getRandomWordFromDictionary()).thenReturn("MAKERS");

        Game game = new Game(mockChoser);
        assertEquals("Game initialises with 10 remaining attempts", Integer.valueOf(10), game.getRemainingAttempts());
    }

    @Test public void testGuessLetter() {
        WordChoser mockChoser = mock(WordChoser.class);
        when(mockChoser.getRandomWordFromDictionary()).thenReturn("MAKERS");

        Game game = new Game(mockChoser);
        assertTrue("Word contains letter 'A'", game.guessLetter('A'));
    }
}
