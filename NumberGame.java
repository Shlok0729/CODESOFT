import java.util.Random;
import java.util.Scanner;

public class NumberGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int totalScore = 0;
        int roundsPlayed = 0;

        System.out.println("Welcome to the Number Guessing Game!");

        while (true) {
            System.out.println("\n--- Round " + (roundsPlayed + 1) + " ---");
            int secretNumber = random.nextInt(100) + 1;  // Generates a number between 1 and 100
            int maxAttempts = 7;
            int attempts = 0;
            boolean guessedCorrectly = false;

            while (attempts < maxAttempts) {
                System.out.print("Attempt " + (attempts + 1) + "/" + maxAttempts +
                        ": Enter your guess (1-100): ");

                int guess;
                try {
                    guess = Integer.parseInt(scanner.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input! Please enter an integer.");
                    continue;
                }

                attempts++;

                if (guess < secretNumber) {
                    System.out.println("Too low!");
                } else if (guess > secretNumber) {
                    System.out.println("Too high!");
                } else {
                    System.out.println("Correct! You've guessed the number in " + attempts + " attempts.");
                    totalScore += maxAttempts - attempts + 1;
                    guessedCorrectly = true;
                    break;
                }
            }

            if (!guessedCorrectly) {
                System.out.println("Out of attempts! The correct number was " + secretNumber + ".");
            }

            roundsPlayed++;
            System.out.println("Score so far: " + totalScore);

            System.out.print("Do you want to play another round? (yes/no): ");
            String playAgain = scanner.nextLine().trim().toLowerCase();
            if (!playAgain.equals("yes")) {
                System.out.println("\nThank you for playing!");
                System.out.println("Total Rounds Played: " + roundsPlayed + ", Final Score: " + totalScore);
                break;
            }
        }

        scanner.close();
    }
}
