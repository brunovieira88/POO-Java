package aula08.ex2;

import java.util.Objects;

public class Legume extends AlimentoVegetariano{
    private String nome;
    
    public Legume(String nome, double proteinas, double calorias, double peso) {
        super(proteinas, calorias, peso);
        this.nome = nome;
    }
    
    public String getNome() { return nome; }
    
    @Override
    public String toString() {
        return String.format("Legume %s, Proteinas %.1f, calorias %.1f, Peso %.1f", 
                           nome, proteinas, calorias, peso);
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Legume other = (Legume) obj;
        return nome.equals(other.nome) && 
               Double.compare(proteinas, other.proteinas) == 0 &&
               Double.compare(calorias, other.calorias) == 0 &&
               Double.compare(peso, other.peso) == 0;
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(nome, proteinas, calorias, peso);
    }
}
