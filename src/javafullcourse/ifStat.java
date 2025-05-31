package javafullcourse;
import java.util.Scanner;

public class ifStat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String name;

        System.out.print("Enter your name: ");
        name = scanner.nextLine();
        if (name.isEmpty()){  // name.isEmpty() is the same as name == ""
            System.out.println("you didnt enter your name 🤬🤬");
        }
        else{
            System.out.println("Hello "+ name + "🧓🧓🧓");
        }
        scanner.close();
    }
}
