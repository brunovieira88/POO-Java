package javafullcourse;
import java.util.Scanner;

public class SquareMethod {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double number;
        double result;

        System.out.print("Enter a number to square: ");
        number = scanner.nextDouble();
        result = square(number);
        System.out.printf("The square of %.0f is: %.0f", number, result);
        scanner.close();
    }
    static double square(double number) {
        return number * number;
    }
}
    


