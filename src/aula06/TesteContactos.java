package aula06;

import aula05.DateYMD;
import java.util.Scanner;

public class TesteContactos {
    public static void main(String[] args) {
        ListaContactos lista = new ListaContactos();
        Scanner scanner = new Scanner(System.in);
        int opcao;

        // contactos exemplo 
        Pessoa pessoa1 = new Pessoa("João Silva", 123456789, new DateYMD(1, 1, 1990));
        lista.addContacto(pessoa1, "912345678", "joao.silva@example.com");

        Pessoa pessoa2 = new Pessoa("Maria Santos", 987654321, new DateYMD(15, 5, 1985));
        lista.addContacto(pessoa2, "923456789", "maria.santos@example.com");

        Pessoa pessoa3 = new Pessoa("Carlos Oliveira", 456789123, new DateYMD(10, 10, 2000));
        lista.addContacto(pessoa3, "934567890", "carlos.oliveira@example.com");

        do {
            System.out.println("\nMenu:");
            System.out.println("1. Inserir contacto");
            System.out.println("2. Alterar contacto");
            System.out.println("3. Apagar contacto");
            System.out.println("4. Procurar contacto");
            System.out.println("5. Listar contactos");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcao) {
                case 1:
                    System.out.print("Nome: ");
                    String nome = scanner.nextLine();
                    System.out.print("CC: ");
                    int cc = scanner.nextInt();
                    scanner.nextLine(); 
                    System.out.print("Data de nascimento (dia mês ano): ");
                    int dia = scanner.nextInt();
                    int mes = scanner.nextInt();
                    int ano = scanner.nextInt();
                    scanner.nextLine();
                    DateYMD dataNasc = new DateYMD(dia, mes, ano);
                    System.out.print("Telefone : ");
                    String telefone = scanner.nextLine();
                    System.out.print("Email : ");
                    String email = scanner.nextLine();
                    Pessoa pessoa = new Pessoa(nome, cc, dataNasc);
                    lista.addContacto(pessoa, telefone, email);
                    break;
                case 2:
                    System.out.print("Insira o nome ou número de telemóvel: ");
                    String pesquisaAlterar = scanner.nextLine();
                    System.out.print("Novo telefone : ");
                    String novoTelefone = scanner.nextLine();
                    System.out.print("Novo email : ");
                    String novoEmail = scanner.nextLine();
                    lista.alterarContacto(pesquisaAlterar, novoTelefone, novoEmail);
                    break;
                case 3:
                    System.out.print("Insira o nome ou número de telemóvel: ");
                    String pesquisaApagar = scanner.nextLine();
                    lista.apagarContacto(pesquisaApagar);
                    break;
                case 4:
                    System.out.print("Insira o nome ou número de telemóvel: ");
                    String pesquisaProcurar = scanner.nextLine();
                    lista.procurarContactos(pesquisaProcurar);
                    break;
                case 5:
                    lista.listarContactos();
                    break;
                case 0:
                    System.out.println("A sair...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 0);
        scanner.close();
    }
}