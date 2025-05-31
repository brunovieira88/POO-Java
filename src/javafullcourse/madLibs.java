package javafullcourse;
import java.util.Scanner;

public class madLibs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        //variables declaration
        String adj1;
        String noun1;
        String adj2;
        String verb;
        String adj3;

        // user inputs
        System.out.print("Enter an adjective (describing a place): ");
        adj1 = scanner.nextLine();
        System.out.print("Enter a noun (person or animal): ");
        noun1 = scanner.nextLine();
        System.out.print("Enter another adjective (describing how something is looking): ");
        adj2 = scanner.nextLine();
        System.out.print("Enter a verb ending with ing (an action): ");
        verb = scanner.nextLine();
        System.out.print("Enter another adjective (describing a reaction you had): ");
        adj3 = scanner.nextLine();
        
        // the actual story
        System.out.println("\nToday I went to a fucking "+adj1+" zoo");
        System.out.println("In a cave I saw "+ noun1);
        System.out.println( noun1+" was looking kinda "+adj2+" and " +verb+"¡");
        System.out.println("I was really "+adj3);

        scanner.close();
    }
}
