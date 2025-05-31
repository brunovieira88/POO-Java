package aula02;

import java.util.Scanner;

public class Ex2_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double sec;
        double min;
        double hours;
        System.out.print("Insere um tempo em segundos: ");
        sec = scanner.nextDouble();
        hours = sec / 3600;
        sec = sec % 3600;
        min = sec / 60;
        sec = sec % 60;
        System.out.printf("%.0f:%.0f:%.0f", hours, min, sec);
        scanner.close();
    }
}
