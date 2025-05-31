package aula08.ex2;

public abstract class AlimentoVegetariano extends Alimento{
    public AlimentoVegetariano(double proteinas, double calorias, double peso) {
        super(proteinas, calorias, peso);
    }
    
    @Override
    public boolean isVegetariano() {
        return true;
    }
}


