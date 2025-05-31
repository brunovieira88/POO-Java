package aula08.ex2;

import java.util.Objects;

public class PratoVegetariano extends Prato{
    public PratoVegetariano(String nome) {
        super(nome);
    }
    
    @Override
    public boolean addIngrediente(Alimento alimento) {
        if (alimento.isVegetariano()) {
            return super.addIngrediente(alimento);
        } else {
            System.out.println("ERRO: não é possível adicionar " + alimento);
            return false;
        }
    }
    
    @Override
    public String toString() {
        return super.toString() + " - Prato Vegetariano";
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        PratoVegetariano other = (PratoVegetariano) obj;
        return getNome().equals(other.getNome()) && 
               getIngredientes().equals(other.getIngredientes());
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(getNome(), getIngredientes());
    }
}
