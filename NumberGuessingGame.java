import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        int score = 0;
        char playAgain;

        System.out.println("🎮 Welcome to the Number Guessing Game!");

        do {
            int min = 1;
            int max = 100;
            int maxAttempts = 7;
            int attempts = 0;

            int randomNumber = random.nextInt(max - min + 1) + min;
            boolean guessedCorrectly = false;

            System.out.println("\nI have chosen a number between " + min + " and " + max);
            System.out.println("You have " + maxAttempts + " attempts to guess it.");

            while (attempts < maxAttempts) {
                System.out.print("Enter your guess: ");
                int guess = sc.nextInt();
                attempts++;

                if (guess == randomNumber) {
                    System.out.println("✅ Correct! You guessed the number in " + attempts + " attempts.");
                    guessedCorrectly = true;
                    score++;
                    break;
                } else if (guess > randomNumber) {
                    System.out.println("📉 Too high!");
                } else {
                    System.out.println("📈 Too low!");
                }
            }

            if (!guessedCorrectly) {
                System.out.println("❌ You've used all attempts. The number was: " + randomNumber);
            }

            System.out.print("\nDo you want to play again? (y/n): ");
            playAgain = sc.next().toLowerCase().charAt(0);

        } while (playAgain == 'y');

        System.out.println("\n🏆 Game Over!");
        System.out.println("Your total score (rounds won): " + score);

        sc.close();
    }
}
