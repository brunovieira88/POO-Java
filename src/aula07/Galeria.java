package aula07;

import java.util.ArrayList;

public class Galeria {
    ArrayList <Obra> obras;

    public Galeria(){
        this.obras = new ArrayList<Obra>();
    }

    public void addObra(Obra obra){
        obras.add(obra);
        System.out.println("Obra adicionada com sucesso");
    }

    public void listarObras(){
        for(Obra obra : obras){
            System.out.println(obra.toString());
        }
    }

    public void venderObra(int id, double precoVenda){
        for(Obra obra: obras){
            if(obra.getId() == id){
                obra.setSellPrice(precoVenda);
                obra.setVendida(true);
                System.out.println("Obra vendida com sucesso");
                return;
            }
        }
        throw new IllegalArgumentException("Obra com ID " + id + " não encontrada.");
    }

    public double lucro(){
        double lucro = 0;
        for(Obra obra:obras){
            lucro += obra.getSellPrice()-obra.getBasePrice();
        }
        return lucro;
    }
}
