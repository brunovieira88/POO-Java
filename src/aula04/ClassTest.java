package aula04;

import java.util.ArrayList;
import java.util.Scanner;

public class ClassTest {
    public static void main(String[] args) {
        ArrayList<Object> figuras = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\nMenu:");
            System.out.println("1. Criar Círculo");
            System.out.println("2. Criar Triângulo");
            System.out.println("3. Criar Retângulo");
            System.out.println("4. Mostrar Figuras");
            System.out.println("5. Comparar Figuras");
            System.out.println("6. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    figuras.add(criarCirculo(scanner));
                    break;
                case 2:
                    figuras.add(criarTriangulo(scanner));
                    break;
                case 3:
                    figuras.add(criarRetangulo(scanner));
                    break;
                case 4:
                    listarFiguras(figuras);
                    break;
                case 5:
                    compararFiguras(figuras, scanner);
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 6);

        scanner.close();
    }

    public static Circle criarCirculo(Scanner scanner) {
        System.out.print("raio do círculo: ");
        double raio = scanner.nextDouble();
        return new Circle(raio,"vermelho");
    }

    public static Triangle criarTriangulo(Scanner scanner) {
        System.out.print("lado 1 do triângulo: ");
        double lado1 = scanner.nextDouble();
        System.out.print("lado 2 do triângulo: ");
        double lado2 = scanner.nextDouble();
        System.out.print("lado 3 do triângulo: ");
        double lado3 = scanner.nextDouble();
        return new Triangle(lado1, lado2, lado3, "verde");
    }

    public static Rectangle criarRetangulo(Scanner scanner) {
        System.out.print("comprimento do retângulo: ");
        double comprimento = scanner.nextDouble();
        System.out.print("altura do retângulo: ");
        double altura = scanner.nextDouble();
        return new Rectangle(comprimento, altura, "azul");
    }

    public static void listarFiguras(ArrayList<Object> figuras) {
        if (figuras.isEmpty()) {
            System.out.println("Nenhuma figura.");
            return;
        }

        for (int i = 0; i < figuras.size(); i++) {
            System.out.println((i + 1) + ". " + figuras.get(i).toString()); // toString de cada figura
        }
    }

    public static void compararFiguras(ArrayList<Object> figuras, Scanner scanner) {
        if (figuras.size() < 2) {
            System.out.println("É necessário ter pelo menos duas figuras para comparar.");
            return;
        }

        listarFiguras(figuras);
        System.out.print("Escolha o índice da primeira figura: ");
        int idx1 = scanner.nextInt() - 1;
        System.out.print("Escolha o índice da segunda figura: ");
        int idx2 = scanner.nextInt() - 1;

        if (idx1 < 0 || idx1 >= figuras.size() || idx2 < 0 || idx2 >= figuras.size()) {
            System.out.println("Índices inválidos!");
            return;
        }

        Object figura1 = figuras.get(idx1);
        Object figura2 = figuras.get(idx2);
 
        if (figura1.equals(figura2)) { //equals de cada figura
            System.out.println("As figuras são iguais.");
        } else {
            System.out.println("As figuras são diferentes.");
        }
    }
}
