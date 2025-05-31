package javafullcourse;
import java.util.Scanner;

public class substr {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String email;
        String username;
        String domain;

        System.out.print("Enter your email: ");
        email = scanner.nextLine();
        if (email.contains("@") && email.contains(".")){
            username = email.substring(0, email.indexOf("@"));
            domain = email.substring(email.indexOf("@"));
            System.out.println(username);
            System.out.println(domain);
        }
        else{
            System.out.println("Your email is not valid");
        }
        scanner.close();
    }
}
