package aula08.ex2;

public class PratoDieta extends Prato{
    private double maxCalorias;
    
    public PratoDieta(String nome, double maxCalorias) {
        super(nome);
        this.maxCalorias = maxCalorias;
    }
    
    @Override
    public boolean addIngrediente(Alimento alimento) {
        if (getCaloriasTotais() + alimento.getCaloriasTotais() <= maxCalorias) {
            return super.addIngrediente(alimento);
        } else {
            System.out.println("ERRO: não é possível adicionar " + alimento);
            return false;
        }
    }
    
    @Override
    public String toString() {
        return super.toString() + String.format(" - Dieta (%.2f Calorias) ", getCaloriasTotais());
    }
}
