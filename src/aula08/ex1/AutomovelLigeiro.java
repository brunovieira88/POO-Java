package aula08.ex1;

public class AutomovelLigeiro extends Veiculo{
    private String numeroQuadro;
    private int capacidadeBagageira;
    
    public AutomovelLigeiro(String matricula, String marca, String modelo, int potencia, String numeroQuadro, int capacidadeBagageira) {
        super(matricula, marca, modelo, potencia);
        this.numeroQuadro = numeroQuadro;
        this.capacidadeBagageira = capacidadeBagageira;
    }
    
    public String getNumeroQuadro() { return numeroQuadro; }
    public int getCapacidadeBagageira() { return capacidadeBagageira; }
    
    @Override
    public String toString() {
        return super.toString() + " - Ligeiro (" + capacidadeBagageira + "L bagageira)";
    }
}
