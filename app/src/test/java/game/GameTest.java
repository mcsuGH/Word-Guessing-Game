package game;

import static org.junit.Assert.*;
import org.junit.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import java.util.ArrayList;

public class GameTest {
    @Test public void testGetsInitialRemainingAttempts() {
        WordChoser mockChoser = mock(WordChoser.class);
        when(mockChoser.getRandomWordFromDictionary()).thenReturn("MAKERS");
        Masker mockMasker = mock(Masker.class);

        Game game = new Game(mockChoser, mockMasker, "Player 1");
        assertEquals("Game initialises with 10 remaining attempts", Integer.valueOf(10), game.getRemainingAttempts());
    }

    @Test public void testGuessLetterTrue() {
        WordChoser mockChoser = mock(WordChoser.class);
        when(mockChoser.getRandomWordFromDictionary()).thenReturn("MAKERS");
        Masker mockMasker = mock(Masker.class);

        Game game = new Game(mockChoser, mockMasker, "Player 1");
        assertTrue("Makers contains letter 'A'", game.guessLetter('A'));
    }

    @Test public void testGuessLetterFalse() {
        WordChoser mockChoser = mock(WordChoser.class);
        when(mockChoser.getRandomWordFromDictionary()).thenReturn("MAKERS");
        Masker mockMasker = mock(Masker.class);

        Game game = new Game(mockChoser, mockMasker, "Player 1");
        assertFalse("Makers does not contain letter 'T'", game.guessLetter('T'));
    }

    @Test public void testReduceRemainingAttempts() {
        WordChoser mockChoser = mock(WordChoser.class);
        when(mockChoser.getRandomWordFromDictionary()).thenReturn("MAKERS");
        Masker mockMasker = mock(Masker.class);

        Game game = new Game(mockChoser, mockMasker, "Player 1");
        game.guessLetter('T');

        assertEquals("Wrong guess removes 1 attempt", Integer.valueOf(9), game.getRemainingAttempts());
    }

    @Test public void testInitialGuessedLetters() {
        WordChoser mockChoser = mock(WordChoser.class);
        when(mockChoser.getRandomWordFromDictionary()).thenReturn("MAKERS");
        Masker mockMasker = mock(Masker.class);
        ArrayList<Character> mockList = new ArrayList<Character>();

        Game game = new Game(mockChoser, mockMasker, "Player 1");
        assertEquals("Guessed letters initially is empty", mockList, game.getGuessedLetters());
    }

    @Test public void testGuessedLetters() {
        WordChoser mockChoser = mock(WordChoser.class);
        when(mockChoser.getRandomWordFromDictionary()).thenReturn("MAKERS");
        Masker mockMasker = mock(Masker.class);
        ArrayList<Character> mockList = new ArrayList<Character>();
        mockList.add('K');

        Game game = new Game(mockChoser, mockMasker, "Player 1");
        game.guessLetter('K');
        assertEquals("Successful guess adds letter to guessed letters", mockList, game.getGuessedLetters());
    }

    @Test public void testIsGameLost() {
        WordChoser mockChoser = mock(WordChoser.class);
        when(mockChoser.getRandomWordFromDictionary()).thenReturn("MAKERS");
        Masker mockMasker = mock(Masker.class);

        Game game = new Game(mockChoser, mockMasker, "Player 1");
        do {
            game.guessLetter('Z');
        } while (game.getRemainingAttempts() > 0);
        assertTrue("Game is lost after losing all remaining attempts", game.isGameLost());
    }

    @Test public void testIsGameWon() {
        WordChoser mockChoser = mock(WordChoser.class);
        when(mockChoser.getRandomWordFromDictionary()).thenReturn("MAKERS");
        Masker mockMasker = mock(Masker.class);

        Game game = new Game(mockChoser, mockMasker, "Player 1");
        game.guessLetter('A');
        game.guessLetter('K');
        game.guessLetter('E');
        game.guessLetter('R');
        game.guessLetter('S');
        when(mockMasker.getsMaskedWord("MAKERS", game.getGuessedLetters())).thenReturn("MAKERS");
        game.updateGuessedWord();

        assertTrue("Game is won after guessing all letters correctly", game.isGameWon());
    }

    @Test public void testIsGameWon2() {
        WordChoser mockChoser = mock(WordChoser.class);
        when(mockChoser.getRandomWordFromDictionary()).thenReturn("LONDON");
        Masker mockMasker = mock(Masker.class);

        Game game = new Game(mockChoser, mockMasker, "Player 1");
        game.guessLetter('O');
        game.guessLetter('N');
        game.guessLetter('D');
        when(mockMasker.getsMaskedWord("LONDON", game.getGuessedLetters())).thenReturn("LONDON");
        game.updateGuessedWord();

        assertTrue("Game is won after guessing all letters correctly", game.isGameWon());
    }

    @Test public void testEmptyName() {
        WordChoser mockChoser = mock(WordChoser.class);
        Masker mockMasker = mock(Masker.class);
        Game game = new Game(mockChoser, mockMasker, "Player 1");

        assertEquals("Name should be Player 1", String.valueOf("Player 1"), game.getName());

    }
}
