package javafullcourse;
import java.util.Scanner;

public class weightconverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int option;
        double inicialWeight;
        double finalWeight;
        System.out.print("Enter your option , 1 for kg to lbs and 2 for lbs to kg: ");
        option = scanner.nextInt();
        if (option == 1){
            System.out.print("Enter the weiht in kg: ");
            inicialWeight = scanner.nextDouble();
            finalWeight = inicialWeight * 2.204;
            System.out.printf("Your weight in lbs is %.2f", finalWeight);
        }
        else if(option == 2){
            System.out.print("Enter the weiht in lbs: ");
            inicialWeight = scanner.nextDouble();
            finalWeight = inicialWeight / 2.204;
            System.out.printf("Your weight in kg is %.2f", finalWeight);
        }
        else{
            System.out.println("Enter a valid option (1 or 2)");
        }
        scanner.close();
    }
}
