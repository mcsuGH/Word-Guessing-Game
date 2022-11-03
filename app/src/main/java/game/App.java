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

        multiPlayer(choser, encryptor, userInput, rand, 2);
    }

    public static void singlePlayer(WordChoser choser, Masker masker, Scanner userInput) {
        Game game = new Game(choser, masker);

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

    public static void multiPlayer(WordChoser choser, Masker masker, Scanner userInput, Random rand, Integer numberOfPlayers) {
        Integer turn = rand.nextInt(numberOfPlayers);
        Integer playerTurn = turn % numberOfPlayers;
        ArrayList<Game> games = new ArrayList<Game>();

        for (int i = 0; i < numberOfPlayers; i++) {
            games.add(new Game(choser, masker));
        }

        for (int i = 0; i < numberOfPlayers; i++) {
            System.out.printf("Enter name for Player %d: ", i + 1);
            games.get(i).setName(userInput.nextLine());
        }

        System.out.println("Welcome! Today the word to guess is:");
        for (Game game : games) {
            System.out.printf("%s: %s \n", game.getName(), game.getWordToGuess());
        };

        while (!isGameOver(games)) {
            if (!games.get(playerTurn).isGameLost()) {
                System.out.printf("\n%s: Enter one letter to guess: (%d attempts remaining): \n", games.get(playerTurn).getName(), games.get(playerTurn).getRemainingAttempts());
                Character guessedLetter = userInput.nextLine().charAt(0);
                Boolean result = games.get(playerTurn).guessLetter(guessedLetter);
                if (result) {
                    System.out.println("Right!");
                } else {
                    System.out.println("Wrong...");
                }
                System.out.printf("%s: %s \n", games.get(playerTurn).getName(), games.get(playerTurn).getWordToGuess());
            }
            turn += 1;
            playerTurn = turn % 2;
        }
        if (isGameOver(games)) {
            if (games.stream().anyMatch(game -> game.isGameWon())) {
                System.out.printf("Congratulations %s! Your word was %s.",
                        games.stream().filter(game -> game.isGameWon()).findFirst().get().getName(),
                        games.stream().filter(game -> game.isGameWon()).findFirst().get().getWordToGuess()
                );
            } else {
                System.out.println("Everybody has used up their attempts!");
            }
        }
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
}

