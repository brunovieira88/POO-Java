package aula08.ex2;

import java.util.Objects;

public class Peixe extends Alimento{
    private Ementa.TipoPeixe tipo;
    
    public Peixe(Ementa.TipoPeixe tipo, double proteinas, double calorias, double peso) {
        super(proteinas, calorias, peso);
        this.tipo = tipo;
    }
    
    public Ementa.TipoPeixe getTipo() { return tipo; }
    
    @Override
    public boolean isVegetariano() { return false; }
    
    @Override
    public String toString() {
        return String.format("Peixe %s, Proteinas %.1f, calorias %.1f, Peso %.1f", 
                           tipo, proteinas, calorias, peso);
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Peixe other = (Peixe) obj;
        return tipo.equals(other.tipo) && 
               Double.compare(proteinas, other.proteinas) == 0 &&
               Double.compare(calorias, other.calorias) == 0 &&
               Double.compare(peso, other.peso) == 0;
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(tipo, proteinas, calorias, peso);
    }
}
