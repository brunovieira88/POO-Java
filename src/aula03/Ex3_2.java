package aula03;

import java.util.Random;
import java.util.Scanner;

public class Ex3_2 {
    public static void main(String[] args) {
        int userChoice;
        int guesses;
        String userContinue = "s";
        Random random = new Random(); 
        Scanner scanner = new Scanner(System.in);
        int num;
        do {
            guesses = 0;
            num = random.nextInt(100); // ou num = (int)(100* Math.random())+1; 
            do {
                System.out.print("Enter your guess: ");
                userChoice = scanner.nextInt();
                guesses++;
                if(userChoice < num){
                    System.out.println("too low!!");
                }
                else if(userChoice > num){
                    System.out.println("too high!!");
                }
            } while (userChoice != num);
            System.out.printf("You've guessed the right number(%d), it took you %d times\n", num, guesses);
            System.out.printf("It took the computer %d times to guess it\n", compT(num , 100));
            System.out.print("Do you want to continue? Press (S) for yes: ");
            userContinue = scanner.next(); 
        } while (userContinue.equalsIgnoreCase("S"));
        scanner.close();
        }

    public static int compT (int n, int front){
        int tries = 0;
        int low = 1;
        int high = front;
        while (low <= high){
            tries ++;
            int mid = low + (high - low)/2;
            if (mid == n){
                return tries;
            }
            else if (n > mid){
                low = mid ;
            }
            else if (n < mid){
                high = mid ;
            }    
        }
        return 999;
    }
}
