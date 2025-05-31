package aula06;

import java.util.ArrayList;
import java.util.Scanner;

public class ListaContactos {
    private ArrayList<Contacto> contactos;

    public ListaContactos(){
        this.contactos = new ArrayList<>();
    }

    public void addContacto(Pessoa pessoa, String numero, String email){
        for (Contacto c : contactos) {
            if (c.getPessoa().equals(pessoa)) {
                Scanner scanner = new Scanner(System.in);
                System.out.println("A pessoa já existe, adicionar como novo contacto? (S/N)");
                String resposta = scanner.nextLine();
                //scanner.close();  para nao crashar o programa
                if (resposta.toLowerCase().equals("n")) {
                    return ;                                                             
                }
                break;
            }
        }
        Contacto novoContacto = new Contacto(pessoa, numero, email);
        contactos.add(novoContacto);
        System.out.println("contacto adicionado");
        
    }

    //procurar contactos por nome ou numero
    public ArrayList<Contacto> procurarContacto(String input) {
        ArrayList<Contacto> resultados = new ArrayList<>();
        for (Contacto c : contactos) {
            if (c.getPessoa().getName().toLowerCase().contains(input.toLowerCase()) || c.getNumero().contains(input)) {
                resultados.add(c);
            }
        }
        return resultados;
    }

    public Contacto selecionarContactoPorID(ArrayList<Contacto> resultados) {
        if (resultados.size() == 1) {
            return resultados.get(0);
        } else {
            System.out.println("encontrados + do que 1 contacto: ");
            for (Contacto c : resultados) {
                System.out.println(c.toString());
            }
            Scanner scanner = new Scanner(System.in);
            System.out.print("insira o ID desejado:");
            int id = scanner.nextInt();
            scanner.nextLine(); 
            //scanner.close(); se der close aqui do scanner o scanner do menu tambem fecha
            for (Contacto c : resultados) {
                if (c.getId() == id) {
                    return c;
                }
            }
            System.out.println("ID invalido.");
            return null;
        }
    }

    public void alterarContacto(String pesquisa, String novoTelefone, String novoEmail) {
        ArrayList<Contacto> resultados;
        resultados = procurarContacto(pesquisa);

        if (resultados.isEmpty()) {
            System.out.println("nenhum contacto encontrado com : " + pesquisa);
        } else {
            Contacto contacto = selecionarContactoPorID(resultados);
            if (contacto != null) {
                if (novoTelefone != null) contacto.setNumero(novoTelefone);
                if (novoEmail != null) contacto.setEmail(novoEmail);
                System.out.println("Contacto alterado");
            }
        }
    }

    public void apagarContacto(String pesquisa) {
        ArrayList<Contacto> resultados;
        resultados = procurarContacto(pesquisa);

        if (resultados.isEmpty()) {
            System.out.println("nenhum contacto encontrado com : " + pesquisa);
        } else {
            Contacto contacto = selecionarContactoPorID(resultados);
            if (contacto != null) {
                contactos.remove(contacto);
                System.out.println("contacto removido");
            }
        }
    }

    public void procurarContactos(String pesquisa) {
        ArrayList<Contacto> resultados;
        resultados = procurarContacto(pesquisa);

        if (resultados.isEmpty()) {
            System.out.println("nenhum contacto encontrado com : " + pesquisa);
        } else {
            for (Contacto c : resultados) {
                System.out.println(c);
            }
        }
    }

    public void listarContactos() {
        if (contactos.isEmpty()) {
            System.out.println("nenhum contacto registado.");
        } else {
            for (Contacto c : contactos) {
                System.out.println(c.toString());
            }
        }
    }
}
