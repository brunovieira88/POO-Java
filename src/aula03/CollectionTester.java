package aula03;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.HashSet;
import java.util.TreeSet;

public class CollectionTester {
    public static void main(String[] args) {
        int[] dimensions = {1000, 5000, 10000, 20000, 40000, 100000}; // tamanhos 

        // cabecalho
        System.out.println("| Collection   | Operation |     1000 |     5000 |    10000 |    20000 |    40000 |   100000 |");
        System.out.println("|--------------|-----------|----------|----------|----------|----------|----------|----------|");

        // fazer os testes
        testCollection(new ArrayList<>(), "ArrayList", dimensions);
        testCollection(new LinkedList<>(), "LinkedList", dimensions);
        testCollection(new HashSet<>(), "HashSet", dimensions);
        testCollection(new TreeSet<>(), "TreeSet", dimensions);
    }

    // metodo para cada coleacao
    private static void testCollection(Collection<Integer> col, String collectionName, int[] dimensions) {
        // teste de adicao
        System.out.printf("| %-12s | %-9s |", collectionName, "Add");
        for (int dim : dimensions) {
            double addTime = checkPerformance(col, dim, "add");
            System.out.printf(" %8.2f |", addTime);
        }
        System.out.println();

        // teste de search
        System.out.printf("| %-12s | %-9s |", collectionName, "Search");
        for (int dim : dimensions) {
            double searchTime = checkPerformance(col, dim, "search");
            System.out.printf(" %8.2f |", searchTime);
        }
        System.out.println();

        // teste de remove
        System.out.printf("| %-12s | %-9s |", collectionName, "Remove");
        for (int dim : dimensions) {
            double removeTime = checkPerformance(col, dim, "remove");
            System.out.printf(" %8.2f |", removeTime);
        }
        System.out.println();
    }

    // medir o tempo 
    private static double checkPerformance(Collection<Integer> col, int DIM, String operation) {
        double start, stop;

        switch (operation) {
            case "add":
                start = System.nanoTime();
                for (int i = 0; i < DIM; i++) {
                    col.add(i);
                }
                stop = System.nanoTime();
                col.clear(); 
                break;

            case "search":
                for (int i = 0; i < DIM; i++) {
                    col.add(i);
                }
                start = System.nanoTime();
                for (int i = 0; i < DIM; i++) {
                    int n = (int) (Math.random() * DIM);
                    col.contains(n);
                }
                stop = System.nanoTime();
                col.clear(); 
                break;

            case "remove":
                for (int i = 0; i < DIM; i++) {
                    col.add(i);
                }
                start = System.nanoTime();
                Iterator<Integer> iterator = col.iterator();
                while (iterator.hasNext()) {
                    iterator.next();
                    iterator.remove();
                }
                stop = System.nanoTime();
                break;

            default:
                throw new IllegalArgumentException("Operação desconhecida: " + operation);
        }

        return (stop - start) / 1e6; // Tempo em milissegundos
    }
}