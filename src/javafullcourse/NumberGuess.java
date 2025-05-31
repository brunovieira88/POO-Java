package javafullcourse;
import java.util.Random;
import java.util.Scanner;

public class NumberGuess {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int secretNumber = random.nextInt(1,101);
        int guess;
        int numberTries = 0;
        do{
            System.out.print("Enter you guess (1-100): ");
            guess = scanner.nextInt();
            numberTries++;
            if (guess > secretNumber){
                System.out.println("too high !!");
            }
            else if (guess < secretNumber){
                System.out.println("too low!!");
            }
        }
        while (guess!=secretNumber);

        System.out.printf("You have won, it took you %d times to guess the number %d !!", numberTries, secretNumber);
        scanner.close();
    }
}
