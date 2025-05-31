package aula03;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Ex3_4_2 {
    public static void main(String[] args) {
        ArrayList<String> nomes = new ArrayList<>();
        ArrayList<Double> notasT = new ArrayList<>();
        ArrayList<Double> notasP = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File("notas.txt"))) {
            while (scanner.hasNextLine()) {
                String linha = scanner.nextLine();
                // dividir linha 
                String[] dados = linha.split("\t");

                nomes.add(dados[0]);
                notasT.add(Double.parseDouble(dados[1]));
                notasP.add(Double.parseDouble(dados[2]));
            }
        } catch (FileNotFoundException e) {
            System.err.println("Erro ao ler o ficheiro: " + e.getMessage());
            return;
        }

        //alunos aprovados
        System.out.println("Alunos aprovados:");
        for (int i = 0; i < nomes.size(); i++) {
            int notaFinal = notaFinal(notasP.get(i), notasT.get(i));
            if (notaFinal != 66 & notaFinal >= 10) { 
                System.out.printf("%s: Nota Final = %d%n", nomes.get(i), notaFinal);
            }
        }
    }

    public static int notaFinal(double nP, double nT) {
        if (nP < 7 || nT < 7) {
            return 66; //nota mínima
        } else {
            double nF = Math.round(0.4 * nT + 0.6 * nP);
            return (int) nF;
        }
    }
}