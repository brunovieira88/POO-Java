package aula01;

import java.util.Scanner;

public class KmToMiles {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double km;
        double miles;
        System.out.print("Distância em km: ");
        km = scanner.nextDouble();
        miles = km/1.69;
        System.out.printf("%.2f km corresponde a %.2f milhas", km, miles);
        scanner.close();
    }
    
}
