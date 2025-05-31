package aula02;

import java.util.Scanner;
public class Ex2_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double xP1;
        double xP2;
        double yP1;
        double yP2;
        double dist;
        System.out.print("Insere coordenada x do P1: ");
        xP1 = scanner.nextDouble();
        System.out.print("Insere coordenada x do P2: ");
        xP2 = scanner.nextDouble();
        System.out.print("Insere coordenada y do P1: ");
        yP1 = scanner.nextDouble();
        System.out.print("Insere coordenada y do P2: ");
        yP2 = scanner.nextDouble();
        dist = Math.sqrt((Math.pow((xP1-xP2),2) + Math.pow((yP1-yP2),2)));
        System.out.printf("distância entre os dois pontos: %.1f", dist);
        scanner.close();
    }
}
