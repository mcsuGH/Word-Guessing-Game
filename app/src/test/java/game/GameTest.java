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

    @Test public void testGuessLetterTrue() {
        WordChoser mockChoser = mock(WordChoser.class);
        when(mockChoser.getRandomWordFromDictionary()).thenReturn("MAKERS");

        Game game = new Game(mockChoser);
        assertTrue("Makers contains letter 'A'", game.guessLetter('A'));
    }

    @Test public void testGuessLetterFalse() {
        WordChoser mockChoser = mock(WordChoser.class);
        when(mockChoser.getRandomWordFromDictionary()).thenReturn("MAKERS");

        Game game = new Game(mockChoser);
        assertFalse("Makers does not contain letter 'T'", game.guessLetter('T'));
    }

    @Test public void testReduceRemainingAttempts() {
        WordChoser mockChoser = mock(WordChoser.class);
        when(mockChoser.getRandomWordFromDictionary()).thenReturn("MAKERS");

        Game game = new Game(mockChoser);
        game.guessLetter('T');
        assertEquals("Wrong guess removes 1 attempt", Integer.valueOf(9), game.getRemainingAttempts());
    }
}
