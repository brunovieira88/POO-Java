package aula02;

import java.util.Scanner;

public class Ex2_3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double catA;
        double catB;
        double hip;
        double angle;
        do {
            System.out.print("Cat A: ");
            catA = scanner.nextDouble();
            System.out.print("Cat B: ");
            catB = scanner.nextDouble();
        } while (catA <= 0 && catB <= 0);
        hip = Math.hypot(catB, catA);
        System.out.println(hip);
        angle = Math.toDegrees(Math.atan2(hip, catA));
        System.out.println("Angle: " + angle);
        scanner.close();
    }
}
