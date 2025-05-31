package javafullcourse;
import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double firstNumber;
        double secNumber;
        char operator;
        double result = 0;
        boolean validOp = true;

        System.out.print("Enter the first number: ");
        firstNumber = scanner.nextDouble();
        System.out.print("Enter the operator (+, -, *, /, ^): ");
        operator = scanner.next().charAt(0);
        System.out.print("Enter the secound number: ");
        secNumber = scanner.nextDouble();

        switch (operator) {
            case '+' -> result = firstNumber + secNumber;
            case '-' -> result = firstNumber - secNumber;
            case '*' -> result = firstNumber * secNumber;
            case '/' -> {
                if (secNumber == 0){
                    System.out.println("The secound number cannot be 0");
                    validOp = false;
                }
                else{
                    result = firstNumber / secNumber;
                }
            }
            case '^' -> result = Math.pow(firstNumber, secNumber);
            default -> {
                System.out.println("The operator does not exist");
                validOp = false;
            }
                
        }
        if (validOp){
            System.out.printf("%.1f %c %.1f = %.2f", firstNumber, operator, secNumber, result);
        }
        scanner.close();
    }
}
