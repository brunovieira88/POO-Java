package aula07;

import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Galeria galeria = new Galeria();
        int opcao;

        do {
            System.out.println("\nMenu:");
            System.out.println("1. Adicionar uma obra");
            System.out.println("2. Listar obras");
            System.out.println("3. Vender uma obra");
            System.out.println("4. Calcular o lucro total");
            System.out.println("5. Sair");
            System.out.print("Opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcao) {
                case 1:
                    adicionarObraMenu(scanner, galeria);
                    break;
                case 2:
                    galeria.listarObras();
                    break;
                case 3:
                    venderObraMenu(scanner, galeria);
                    break;
                case 4:
                    System.out.printf("Lucro total: %.1f\n", galeria.lucro());
                    break;
                case 5:
                    System.out.println("5. Sair");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 5);

        scanner.close();
    }

    private static void adicionarObraMenu(Scanner scanner, Galeria galeria) {
        System.out.println("\nAdicionar uma obra do tipo");
        System.out.println("1. Quadro");
        System.out.println("2. Escultura");
        System.out.println("3. Obra Digital (NFT)");
        System.out.print("Tipo de produto: ");
        int tipo = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Nome da Obra: ");
        String nome = scanner.nextLine();
        System.out.print("Autor da Obra: ");
        String autor = scanner.nextLine();
        System.out.print("Preço da Obra: ");
        double preco = scanner.nextDouble();
        scanner.nextLine(); 

        switch (tipo) {
            case 1: // Quadro
                String tipoTinta="";
                System.out.println("Tipo de Tinta: ");
                System.out.println("1. óleo");
                System.out.println("2. guache");
                System.out.println("s. Aguarela");
                System.out.print("opçao: ");
                int opTinta = scanner.nextInt();
                scanner.nextLine(); 
                switch (opTinta) {
                    case 1:
                        tipoTinta = "óleo";
                        break;
                    case 2:
                        tipoTinta = "guache";
                        break;
                    case 3:
                        tipoTinta = "aguarela";
                    default:
                        throw new IllegalArgumentException("opcao invalida");
                }
                System.out.print("Obra emoldurada? (s/n): ");
                boolean emoldurada = scanner.nextLine().equalsIgnoreCase("s");
                System.out.print("Tamanho da Tela (S, M, L ou XL): ");
                String tamanhoTela = scanner.nextLine();
                galeria.addObra(new Quadro(nome, autor, preco, tipoTinta, emoldurada, tamanhoTela));
                break;
                
            case 2: // Escultura
            String materialEs = "";
                System.out.println("Material: ");
                System.out.println("1. Madeira");
                System.out.println("2. Ceramica");
                System.out.println("3. Metal");
                System.out.print("opcao: ");    
                int materialOp = scanner.nextInt();
                scanner.nextLine(); 
                switch (materialOp) {
                    case 1:
                        materialEs = "Madeira";
                        break;
                    case 2:
                        materialEs = "Ceramica";
                        break;
                    case 3:
                        materialEs = "Metal";
                    default:
                        throw new IllegalArgumentException("opcao invalida");
                }
                System.out.print("Quantos exemplares foram produzidos: ");
                int exemplares = scanner.nextInt();
                boolean unica = exemplares >1 ? false: true;
                scanner.nextLine(); 
                
                galeria.addObra(new Escultura(nome, autor, preco, materialEs, unica, exemplares));
                break;
                
            case 3: // Obra Digital
                System.out.print("Nome da Blockchain: ");
                String blockchain = scanner.nextLine();
                System.out.print("Endereço do Contrato: ");
                String contrato = scanner.nextLine();
                
                galeria.addObra(new ObraDigital(nome, autor, preco, blockchain, contrato));
                break;
                
            default:
                System.out.println("Tipo inválido!");
        }
    }

    private static void venderObraMenu(Scanner scanner, Galeria galeria) {
        System.out.println("\n3. Vender uma obra");
        System.out.print("Identificador da Obra: ");
        int id = scanner.nextInt();
        System.out.print("Preço de venda: ");
        double precoVenda = scanner.nextDouble();
        scanner.nextLine(); 
        galeria.venderObra(id, precoVenda);
    }
}