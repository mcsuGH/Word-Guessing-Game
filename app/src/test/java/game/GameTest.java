package game;

import static org.junit.Assert.*;
import org.junit.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import java.util.ArrayList;

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
        game.guessLetter('E');
        assertEquals("Game initialises with random word", "DE_E___E_", game.getWordToGuess());
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

    @Test public void testInitialGuessedLetters() {
        WordChoser mockChoser = mock(WordChoser.class);
        when(mockChoser.getRandomWordFromDictionary()).thenReturn("MAKERS");
        ArrayList<Character> mockList = new ArrayList<Character>();
        mockList.add('M');

        Game game = new Game(mockChoser);
        assertEquals("Guessed letters initially contains first letter", mockList, game.getGuessedLetters());
    }

    @Test public void testGuessedLetters() {
        WordChoser mockChoser = mock(WordChoser.class);
        when(mockChoser.getRandomWordFromDictionary()).thenReturn("MAKERS");
        ArrayList<Character> mockList = new ArrayList<Character>();
        mockList.add('M');
        mockList.add('K');

        Game game = new Game(mockChoser);
        game.guessLetter('K');
        assertEquals("Successful guess adds letter to guessed letters", mockList, game.getGuessedLetters());
    }
}
