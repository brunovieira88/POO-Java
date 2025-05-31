package aula09.ex2;

import java.util.Scanner;

public class PlaneTester {
    public static void main(String[] args) {
        PlaneManager manager = new PlaneManager();
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.println("\n=== Menu de Gestão de Frota ===");
            System.out.println("1. Adicionar avião comercial");
            System.out.println("2. Adicionar avião militar");
            System.out.println("3. Remover avião");
            System.out.println("4. Procurar avião");
            System.out.println("5. Listar todos os aviões");
            System.out.println("6. Listar aviões comerciais");
            System.out.println("7. Listar aviões militares");
            System.out.println("8. Mostrar avião mais rápido");
            System.out.println("0. Sair");
            System.out.print("Opção: ");
            
            int option = scanner.nextInt();
            scanner.nextLine(); // Limpar buffer
            
            switch (option) {
                case 1:
                    addCommercialPlane(manager, scanner);
                    break;
                case 2:
                    addMilitaryPlane(manager, scanner);
                    break;
                case 3:
                    removePlane(manager, scanner);
                    break;
                case 4:
                    searchPlane(manager, scanner);
                    break;
                case 5:
                    manager.printAllPlanes();
                    break;
                case 6:
                    printCommercialPlanes(manager);
                    break;
                case 7:
                    printMilitaryPlanes(manager);
                    break;
                case 8:
                    printFastestPlane(manager);
                    break;
                case 0:
                    System.out.println("A sair do programa...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }

    private static void addCommercialPlane(PlaneManager manager, Scanner scanner) {
        System.out.println("\nAdicionar avião comercial:");
        System.out.print("ID: ");
        String id = scanner.nextLine();
        System.out.print("Fabricante: ");
        String manufacturer = scanner.nextLine();
        System.out.print("Modelo: ");
        String model = scanner.nextLine();
        System.out.print("Ano de produção: ");
        int year = scanner.nextInt();
        System.out.print("Número máximo de passageiros: ");
        int maxPassengers = scanner.nextInt();
        System.out.print("Velocidade máxima: ");
        int maxSpeed = scanner.nextInt();
        System.out.print("Número de tripulantes: ");
        int crew = scanner.nextInt();
        scanner.nextLine(); 
        
        ComercialPlane plane = new ComercialPlane(id, manufacturer, model, year, 
                                                  maxPassengers, maxSpeed, crew);
        manager.addPlane(plane);
        System.out.println("Avião comercial adicionado com sucesso!");
    }

    private static void addMilitaryPlane(PlaneManager manager, Scanner scanner) {
        System.out.println("\nAdicionar avião militar:");
        System.out.print("ID: ");
        String id = scanner.nextLine();
        System.out.print("Fabricante: ");
        String manufacturer = scanner.nextLine();
        System.out.print("Modelo: ");
        String model = scanner.nextLine();
        System.out.print("Ano de produção: ");
        int year = scanner.nextInt();
        System.out.print("Número máximo de passageiros: ");
        int maxPassengers = scanner.nextInt();
        System.out.print("Velocidade máxima: ");
        int maxSpeed = scanner.nextInt();
        System.out.print("Número de munições: ");
        int ammo = scanner.nextInt();
        scanner.nextLine();
        
        MilitaryPlane plane = new MilitaryPlane(id, manufacturer, model, year, 
                                              maxPassengers, maxSpeed, ammo);
        manager.addPlane(plane);
        System.out.println("Avião militar adicionado com sucesso!");
    }

    private static void removePlane(PlaneManager manager, Scanner scanner) {
        System.out.print("\nID do avião a remover: ");
        String id = scanner.nextLine();
        manager.removePlane(id);
        System.out.println("Avião removido (se existia).");
    }

    private static void searchPlane(PlaneManager manager, Scanner scanner) {
        System.out.print("\nID do avião a procurar: ");
        String id = scanner.nextLine();
        Plane plane = manager.searchPlane(id);
        if (plane != null) {
            System.out.println("Avião encontrado:\n" + plane);
        } else {
            System.out.println("Avião não encontrado.");
        }
    }

    private static void printCommercialPlanes(PlaneManager manager) {
        System.out.println("\nAviões comerciais:");
        for (ComercialPlane plane : manager.getComercialPlanes()) {
            System.out.println(plane);
        }
    }

    private static void printMilitaryPlanes(PlaneManager manager) {
        System.out.println("\nAviões militares:");
        for (MilitaryPlane plane : manager.getMilitaryPlanes()) {
            System.out.println(plane);
        }
    }

    private static void printFastestPlane(PlaneManager manager) {
        Plane fastest = manager.getFastestPlane();
        if (fastest != null) {
            System.out.println("\nAvião mais rápido:");
            System.out.println(fastest);
        } else {
            System.out.println("Não há aviões na frota.");
        }
    }
}
