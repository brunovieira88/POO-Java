package javafullcourse;
import java.util.Scanner;
public class Main {
    public static void main(String[] args){
        /* 
        DATA TYPES
        double lastGrade = 19.5;
        String name = "Bruno";
        char grade = 'A';
        boolean isStudent = false;
        System.out.println("Hi " + name);
        if (isStudent){
            System.out.println("Your grade is " + grade + " and your last test you had " + lastGrade);
        }
        else{
            System.out.println("Your are NOT a student");
        };
        */
        
        //User Input
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your name: "); //printLn would change to the next line to write the input
        String name = scanner.nextLine(); //if it was next it would read till a blanck space
        System.out.print("Enter you body count: ");
        int bodyCount = scanner.nextInt();
        if (bodyCount <= 5){
            System.out.println("Hi " + name);
            System.out.println("Ur body count is " +bodyCount+ " , you not a whore");
        }
        else{
            System.out.println("Ur body count is " +bodyCount+ " , you're COOKED");
        }
        System.out.print("Your weight: ");
        double weight = scanner.nextDouble();
        if (weight <= 70){
            System.out.println("Hi " + name);
            System.out.println("Ur weight is " +weight+ " , you fine");
        }
        else{
            System.out.println("Ur weight is " +weight+ " , close your mouth");
        }
        scanner.close(); //fechar sempre o scanner
    }
}
