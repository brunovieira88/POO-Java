package javafullcourse;
import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        String[] choises = {"rock", "paper", "scissors"};
        String playerChoise;
        String computerChoise;
        String playAgain = "yes";
        do {
            System.out.print("Enter your move: ");
            playerChoise = scanner.nextLine().toLowerCase(); //lower caso o user use caps
            
            if (!playerChoise.equals("rock") && !playerChoise.equals("paper") && !playerChoise.equals("scissors")) {
                System.out.println("Invalid choise");
            }
            computerChoise = choises[random.nextInt(3)];
            System.out.printf("computer choise: %s\n",computerChoise);
            if (playerChoise.equals(computerChoise)) {
                System.out.println("TIE!!");
            } 
            else if ((playerChoise.equals("rock") && computerChoise.equals("scissors")) ||  (playerChoise.equals("paper") && computerChoise.equals("rock")) || (playerChoise.equals("scissors") && computerChoise.equals("paper"))) {
                System.out.println("YOU WIN");
            }
            else{
                System.out.println("YOU LOSE!!");
            }
            System.out.print("type yes to play again: ");
            playAgain = scanner.nextLine();
        } while (playAgain.equals("yes"));
        

        scanner.close();
    }
}
