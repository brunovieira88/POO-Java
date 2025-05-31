package aula08.ex2;

import java.util.Objects;

public class Carne extends Alimento{
    private Ementa.VariedadeCarne variedade;
    public Carne(Ementa.VariedadeCarne variedade, double proteinas, double calorias, double peso) {
        super(proteinas, calorias, peso);
        this.variedade = variedade;
    }
    public Ementa.VariedadeCarne getVariedade() { return variedade; }    
    @Override
    public boolean isVegetariano() { return false; }
    
    @Override
    public String toString() {
        return String.format("Carne %s, Proteinas %.1f, calorias %.1f, Peso %.1f",variedade, proteinas, calorias, peso);
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Carne other = (Carne) obj;
        return variedade.equals(other.variedade) && 
               Double.compare(proteinas, other.proteinas) == 0 &&
               Double.compare(calorias, other.calorias) == 0 &&
               Double.compare(peso, other.peso) == 0;
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(variedade, proteinas, calorias, peso);
    }         
}
