/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package game;

import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;

public class App {
    public static void main(String[] args) {
        WordChoser choser = new WordChoser();
        Masker encryptor = new Masker();
        Random rand = new Random();
        Scanner userInput = new Scanner(System.in);

        System.out.print("Please enter the number of players: ");
        Integer numberOfPlayers = userInput.nextInt();
        userInput.nextLine(); //Skips entering name for 1st player without this line
        Integer initialTurn = rand.nextInt(numberOfPlayers);
        multiPlayer(choser, encryptor, userInput, initialTurn, numberOfPlayers);
    }

    public static void multiPlayer(WordChoser choser, Masker masker, Scanner userInput, Integer initialTurn, Integer numberOfPlayers) {
        ArrayList<Game> games = new ArrayList<Game>();

        setupGame(games, numberOfPlayers, choser, masker, userInput);
        playGame(games, userInput, initialTurn, numberOfPlayers);
        endGame(games);
    }

    public static void setupGame(ArrayList<Game> games, Integer numberOfPlayers, WordChoser choser, Masker masker, Scanner userInput) {
        for (int i = 0; i < numberOfPlayers; i++) {
            System.out.printf("Enter name for Player %d: ", i + 1);
            String playerName = userInput.nextLine();
            games.add(new Game(choser, masker, playerName));
        }

        System.out.println("Welcome! Today the word to guess is:");
        for (Game game : games) {
            System.out.printf("%s: %s \n", game.getName(), game.getWordToGuess());
        };
    }

    public static Boolean isGameOver(ArrayList<Game> games) {
        if (games.stream().anyMatch(game -> game.isGameWon())) {
            return true;
        }
        if (games.stream().allMatch(game -> game.isGameLost())) {
            return true;
        }
        return false;
    }

    public static void playGame(ArrayList<Game> games, Scanner userInput, Integer initialTurn, Integer numberOfPlayers) {
        Integer turn = initialTurn;

        while (!isGameOver(games)) {
            Integer playerTurn = turn % numberOfPlayers;
            Game currentPlayer = games.get(playerTurn);
            if (!currentPlayer.isGameLost()) {
                System.out.printf("\n%s: Enter one letter to guess: (%d attempts remaining): \n", currentPlayer.getName(), currentPlayer.getRemainingAttempts());
                Character guessedLetter = userInput.nextLine().charAt(0);
                Boolean result = currentPlayer.guessLetter(guessedLetter);
                if (result) {
                    System.out.println("Right!");
                } else {
                    System.out.println("Wrong...");
                }
                System.out.printf("%s: %s \n", currentPlayer.getName(), currentPlayer.getWordToGuess());
            }
            turn += 1;
        }
    }

    public static void endGame(ArrayList<Game> games) {
        if (isGameOver(games)) {
            if (games.stream().anyMatch(game -> game.isGameWon())) {
                Game winner = games.stream().filter(game -> game.isGameWon()).findAny().get();
                System.out.printf("Congratulations %s! The word was %s. \n", winner.getName(), winner.getWordToGuess());
            } else {
                System.out.println("Everybody has used up their attempts!");
            }
        }
    }
}
