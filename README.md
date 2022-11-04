# Word Guessing Game

## Task
Word Guessing Game is a game where multiple players are each assigned a random word from a list and take turns in guessing letters for their word, when any of the players have guessed all the letters correctly, they will win the game. The game is lost when all players use up all of their guessing attempts.\
\
This program was built using Java and tested using JUnit.

## Instructions
Use `git clone ` to clone this repository to your local machine, then open the project in an IDE such as VSCode. Run the file `App.java` and then play the game!

## Features
- Can enter the number of players before the game begins
- Can enter a name for each player
- Each player is given a random word from a list as their word to guess
- The first player to guess is randomly chosen
- Each player is then given their chance to guess in order
- Each player can have up to 10 wrong guesses
- When a player has run out of guesses, their turn will be skipped
- The game ends when any of the players have won
- The game ends when all the players have lost
- Message at the end of the game to say who won and what their word was, or to say every player has used up their attempts
### Example Output:
```
Please enter the number of players: 2
Enter name for Player 1: Bob
Enter name for Player 2: Jack
Welcome! Today the word to guess is:
Bob: M_____ 
Jack: D________ 

Jack: Enter one letter to guess: (10 attempts remaining): 
A
Wrong...
Jack: D________ 

Bob: Enter one letter to guess: (10 attempts remaining): 
A
Right!
Bob: MA____ 

Jack: Enter one letter to guess: (9 attempts remaining): 
K
Wrong...
Jack: D________ 

Bob: Enter one letter to guess: (10 attempts remaining): 
K
Right!
Bob: MAK___ 

Jack: Enter one letter to guess: (8 attempts remaining): 
E
Right!
Jack: DE_E___E_ 

Bob: Enter one letter to guess: (10 attempts remaining): 
E
Right!
Bob: MAKE__ 

Jack: Enter one letter to guess: (8 attempts remaining): 
R
Right!
Jack: DE_E___ER 

Bob: Enter one letter to guess: (10 attempts remaining): 
R
Right!
Bob: MAKER_ 

Jack: Enter one letter to guess: (8 attempts remaining): 
S
Wrong...
Jack: DE_E___ER 

Bob: Enter one letter to guess: (10 attempts remaining): 
S
Right!
Bob: MAKERS 
Congratulations Bob! The word was MAKERS.               
```



