/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package game;

import org.junit.*;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.*;
import java.util.ArrayList;

public class AppTest {
    private static final WordChoser mockChoser = mock(WordChoser.class);

    @Before public void setupTests() {
        when(mockChoser.getRandomWordFromDictionary()).thenReturn("MAKERS");
    }

    @Test public void testApp() throws IOException {
        String[] appOutput = runApp("Maker\nA\nK\nE\nR\nS");

        assertEquals("Enter name for Player 1: ", appOutput[0]);
        assertEquals("Welcome! Today the word to guess is:", appOutput[1]);
        assertEquals("Maker: M_____ \n", appOutput[2]);

        assertEquals("\nMaker: Enter one letter to guess: (10 attempts remaining): \n", appOutput[3]);
        assertEquals("Right!): \n", appOutput[4]);
        assertEquals("Maker: MA____): \n", appOutput[5]);

        assertEquals("\nMaker: Enter one letter to guess: (10 attempts remaining): \n", appOutput[6]);
        assertEquals("Right!): \n", appOutput[7]);
        assertEquals("Maker: MAK___): \n", appOutput[8]);

        assertEquals("\nMaker: Enter one letter to guess: (10 attempts remaining): \n", appOutput[9]);
        assertEquals("Right!): \n", appOutput[10]);
        assertEquals("Maker: MAKE__): \n", appOutput[11]);

        assertEquals("\nMaker: Enter one letter to guess: (10 attempts remaining): \n", appOutput[12]);
        assertEquals("Right!): \n", appOutput[13]);
        assertEquals("Maker: MAKER_): \n", appOutput[14]);

        assertEquals("\nMaker: Enter one letter to guess: (10 attempts remaining): \n", appOutput[15]);
        assertEquals("Right!): \n", appOutput[16]);
        assertEquals("Maker: MAKERS): \n", appOutput[17]);

        assertEquals("Congratulations Maker! The word was MAKERS.", appOutput[18]);
    }

    private String[] runApp(String userInput) throws IOException {
        // instead of System.in (what a user types into the console)
        InputStream input = new ByteArrayInputStream(userInput.getBytes());

        // instead of System.out (what the console returns)
        ArrayList<Character> captured = new ArrayList<>();
        OutputStream output = new OutputStream() {
            @Override
            public void write(int inByteValue) throws IOException {
                captured.add((char) inByteValue);
            }
        };

        App app = new App(input, new PrintStream(output), mockChoser, new Masker());
        app.multiPlayer(0, 1);

        // modify captured to something that is testable
        String appOutput = captured.stream()
                .map(Object::toString)
                .reduce("", (acc, e) -> acc  + e);
        return appOutput.split("\\r?\\n");
    }

}
