package aula03;

import java.util.Scanner;
import java.util.ArrayList;

public class Ex3_4 {
    public static void main(String[] args) {
        int nF;
        double notaP, notaT;
        ArrayList<Double> notasP = new ArrayList<>();
        ArrayList<Double> notasT = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Insira as notas da com pratica e teorica.");
        System.out.println("Para parar insira uma nota superior a 20.");
        while(true){
            System.out.print("Insira a nota da CP: ");
            notaP = scanner.nextDouble();
            if (notaP > 20){break;}
            System.out.print("Insira a nota da CT: ");
            notaT = scanner.nextDouble();
            if (notaT > 20){break;}

            notasP.add(notaP);
            notasT.add(notaT);

        };
        System.out.println("NotaT | NotaP | Pauta");
        for (int i = 0; i < notasP.size(); i++){
            nF = notaFinal(notasP.get(i), notasT.get(i));
            System.out.printf("%5.1f | %5.1f | %5d%n", notasT.get(i), notasP.get(i), nF);
        }
        scanner.close();
    }
    public static int notaFinal(double nP, double nT){
        if (nP < 7 || nT < 7){
            return 66; //nota minima 
        }else{
            double nF = Math.round(0.4 * nT + 0.6 * nP);
            return (int)nF;
        }
    } 
}
