import java.util.Scanner;
import java.util.Random;

public class NumberGuessingGame {
    public static void main(String[] args ){
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int minRange = 1;
        int maxRange = 100;
        int attemptsLimit=5;
        int score=0;

        boolean playAgain = true;
        while (playAgain){
            int generatedNumber=random.nextInt(maxRange + 1) + minRange;
            System.out.println("Welcome to the Number Guessing Game!");
            System.out.println("Guess a number between "+ minRange + "and" + maxRange +".");
            System.out.println("You have "+ attemptsLimit + "attempts.");

            int attempts = 0;
            boolean guessedCorrectly = false;
            while (attempts < attemptsLimit){
                System.out.print("Enter your guess:");
                int guess = scanner.nextInt();
                attempts++;
                if(guess == generatedNumber){
                    System.out.println("Congratulation! You guessed the correct number.");
                    guessedCorrectly = true;
                    score++;
                    break;
                
                }else if (guess < generatedNumber) {
                    System.out.println("Too low. Try again");
                }else{
                    System.out.println("Too high. Try again");
                }
            }

            if (!guessedCorrectly){
                System.out.println("Out of attempts . The correct number was :" + generatedNumber);
            }
            System.out.println("Your score :" + score );
            System.out.print("DO you want to play again ? (yes/no):");
            String playChoice = scanner.next();
            if (!playChoice.equalsIgnoreCase("yes")){
                playAgain = false;
            }
        }
        System.out.println("Thank you for playing!");
        scanner.close();
    }
}