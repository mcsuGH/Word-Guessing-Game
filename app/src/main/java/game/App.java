/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package game;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        multiPlayer();
    }

    public static void singlePlayer() {
        WordChoser choser = new WordChoser();
        Masker encryptor = new Masker();
        Game game = new Game(choser, encryptor);
        Scanner userInput = new Scanner(System.in);

        System.out.println("Welcome! Today the word to guess is:");
        do {
            System.out.println(game.getWordToGuess());
            System.out.printf("Enter one letter to guess (%d attempts remaining):", game.getRemainingAttempts());
            Character guessedLetter = userInput.nextLine().charAt(0);
            Boolean result = game.guessLetter(guessedLetter);
            if (result) {
                System.out.println("Right!");
            } else {
                System.out.println("Wrong...");
            }
        } while (!game.isGameLost() && !game.isGameWon());
        if (game.isGameWon()) {
            System.out.printf("You guessed it right! The word was %s.", game.getWordToGuess());
        }
        if (game.isGameLost()) {
            System.out.println("You have ran out of attempts!");
        }
    }

    public static void multiPlayer() {
        WordChoser choser = new WordChoser();
        Masker encryptor = new Masker();
        Game player1 = new Game(choser, encryptor);
        Game player2 = new Game(choser, encryptor);
        Scanner userInput = new Scanner(System.in);

        System.out.println("Welcome! Today the word to guess is:");
        System.out.printf("Player 1: %s \n", player1.getWordToGuess());
        System.out.printf("Player 2: %s \n", player2.getWordToGuess());
    }
}

