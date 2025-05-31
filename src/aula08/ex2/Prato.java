package aula08.ex2;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Prato implements Comparable<Prato>{
    protected String nome;
    protected List<Alimento> ingredientes;
    
    public Prato(String nome) {
        this.nome = nome;
        this.ingredientes = new ArrayList<>();
    }
    
    public String getNome() { return nome; }
    
    public boolean addIngrediente(Alimento alimento) {
        return ingredientes.add(alimento);
        }
        
        public double getPesoTotal() {
        double totalPeso = 0;
        for (Alimento alimento : ingredientes) {
            totalPeso += alimento.getPeso();
        }
        return totalPeso;
        }
        
        public double getCaloriasTotais() {
        double totalCalorias = 0;
        for (Alimento alimento : ingredientes) {
            totalCalorias += alimento.getCaloriasTotais();
        }
        return totalCalorias;
        }
        
        public double getProteinasTotais() {
        double totalProteinas = 0;
        for (Alimento alimento : ingredientes) {
            totalProteinas += alimento.getProteinasTotais();
        }
        return totalProteinas;
        }
        
        @Override
        public int compareTo(Prato p) {
        return Double.compare(this.getCaloriasTotais(), p.getCaloriasTotais());
    }
    
    @Override
    public String toString() {
        return String.format("Prato '%s', composto por %d Ingredientes", 
                           nome, ingredientes.size());
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Prato other = (Prato) obj;
        return nome.equals(other.nome) && ingredientes.equals(other.ingredientes);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(nome, ingredientes);
    }

    public List<Alimento> getIngredientes() {
        return ingredientes;
    }
}
