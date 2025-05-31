package aula02;

import java.util.Scanner;

public class Ex2_7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String nameOg;
        String acr = "";
        System.out.print("insere um nome: ");
        nameOg = scanner.nextLine();
        String[] sep = nameOg.split(" ");
        for ( String x : sep){
            if(x.length()>3){
                acr +=x.charAt(0);
            }
        }
        System.out.println("Acrónimo: "+acr);
        scanner.close();
    }
}
