package javafullcourse;
import java.util.Scanner;

public class evenNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number;
        String evenOrOdd;
        System.out.print("Enter an integrer: ");
        number = scanner.nextInt();
        evenOrOdd = (number % 2 == 0)? "even" : "odd"; // ? is a ternary operator the firts string is if the condition is true
        System.out.printf("The number %d is %s", number, evenOrOdd);
        scanner.close();
    }
}
