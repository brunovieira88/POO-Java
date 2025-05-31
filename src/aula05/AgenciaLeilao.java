package aula05;

import java.util.ArrayList;

public class AgenciaLeilao {
    private ArrayList<Imovel> imoveis;

    // construtor
    public AgenciaLeilao() {
        imoveis = new ArrayList<>();
    }

    public void addImovel(Imovel imovel) {
        imoveis.add(imovel);
    }

    public void sellImovel(int id) {
        for (Imovel imovel : imoveis) {
            if (imovel.getId() == id) {
                imovel.setDisponivel(false);
                System.out.println("Imóvel " + id + " vendido.");
                return;
            }
        }
        System.out.println("Imóvel " + id + " não existe.");
    }

    public void verificarDisponibilidade(int id) {
        for (Imovel imovel : imoveis) {
            if (imovel.getId() == id) {
                String disponibilidade = imovel.isDisponivel() ? "sim" : "não";
                System.out.println("Imóvel " + id + " está disponível: " + disponibilidade + ".");
                return;
            }
        }
        System.out.println("Imóvel " + id + " não existe.");
    }

    public void listImoveis() {
        System.out.println("Propriedades:");
        for (Imovel imovel : imoveis) {
            System.out.println(imovel);
        }
    }
}
