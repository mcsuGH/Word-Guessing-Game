package game;

import static org.junit.Assert.*;
import org.junit.Test;

public class GameTest {
    @Test public void testGetsWordToGuess() {
        Game game = new Game();
        assertEquals("Game initialises with given word", "M_____", game.getWordToGuess());
    }

    @Test public void testGetsInitialRemainingAttempts() {
        Game game = new Game();
        assertEquals("Game initialises with 10 remaining attempts", Integer.valueOf(10), game.getRemainingAttempts());
    }
}
