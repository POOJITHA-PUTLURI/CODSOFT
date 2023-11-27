import java.util.Random;
import java.util.Scanner;

public class NumberGame {
    public static void main(String[] args) {
        Scanner inputScanner = new Scanner(System.in);
        Random randomNumberGenerator = new Random();

        int minValue = 1;
        int maxValue = 100;
        int remainingChances = 10;
        int gamesPlayed = 0;
        int playerScore = 0;
        System.out.println();
        System.out.println("Let's play a Number Guessing Game!");
        System.out.println();
        System.out.println("You have " + remainingChances + " attempts to guess the mystery number between " + minValue + " and " + maxValue);

        boolean playAnotherRound = true;

        while (playAnotherRound) {
            int secretNumber = randomNumberGenerator.nextInt(maxValue - minValue + 1) + minValue;
            int userGuess;
            boolean isCorrectGuess = false;

            while (remainingChances > 0) {
                System.out.print("Enter your guess from 1 to 100: ");
                userGuess = inputScanner.nextInt();
                remainingChances--;

                if (userGuess < minValue || userGuess > maxValue) {
                    System.out.println("Your guess is outside the valid range. Please guess between " + minValue + " and " + maxValue);
                    System.out.println();
                } else if (userGuess < secretNumber) {
                    System.out.println("Your guess is lower than the mystery number. You have " + remainingChances + " attempts left.");
                    System.out.println();
                } else if (userGuess > secretNumber) {
                    System.out.println("Your guess is higher than the mystery number. You have " + remainingChances + " attempts left.");
                    System.out.println();
                } else {
                    System.out.println("Congratulations! You guessed the correct number: " + secretNumber);
                    System.out.println();
                    isCorrectGuess = true;
                    break;
                }
            }

            if (isCorrectGuess) {
                playerScore++;
            } else {
                System.out.println("Out of attempts. The mystery number was: " + secretNumber);
            }

            System.out.println("Your current score: " + playerScore);
            System.out.println();
            gamesPlayed++;

            System.out.print("Would you like to play another round? (yes/no): ");
            System.out.println();
            String playAgainResponse = inputScanner.next().toLowerCase();
            playAnotherRound = playAgainResponse.equals("yes");

            if (playAnotherRound) {
                remainingChances = 10;
                System.out.println("Starting a new round!");
            } else {
                System.out.println("Thanks for playing! You completed " + gamesPlayed + " rounds, and your final score is: " + playerScore);
            }
        }

        inputScanner.close();
    }
}
