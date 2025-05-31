package javafullcourse;
import java.util.Scanner;

public class Banking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double balance = 0;
        int choise = 0;
        double amount;
        while (choise != 4){
            System.out.println("-------------------");
            System.out.println("Show balance - 1");
            System.out.println("Make a deposit - 2");
            System.out.println("Withdraw money - 3");
            System.out.println("Exit - 4");
            System.out.print("Enter your choise: ");
            choise = scanner.nextInt();

            switch(choise){
                case 1 -> showBalance(balance);
                case 2 ->{
                    System.out.print("Enter the amount u want to deposit: ");
                    amount = scanner.nextDouble();
                    balance = makeDeposit(amount, balance);
                }
                case 3 ->{
                    System.out.print("Enter the amount u want to withdraw: ");
                    amount = scanner.nextDouble();
                    balance = makeWithdraw(amount, balance);
                }
                default -> System.out.println("Enter a valid option, 1 to 4"); 
            };
        }
        scanner.close();
    }
    static void showBalance(double balance){
        System.out.printf("Your balance is %.2f\n", balance);
    }
    static double makeDeposit(double value, double balance){
        balance += value;
        return balance;
    }
    static double makeWithdraw(double value, double balance){
        balance -= value;
        return balance;
    }
}
