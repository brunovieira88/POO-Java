package aula08.ex1;

public class PesadoPassageiros extends Veiculo{
    private String numeroQuadro;
    private double peso;
    private int maxPassageiros;
    
    public PesadoPassageiros(String matricula, String marca, String modelo, int potencia, String numeroQuadro, double peso, int maxPassageiros) {
        super(matricula, marca, modelo, potencia);
        this.numeroQuadro = numeroQuadro;
        this.peso = peso;
        this.maxPassageiros = maxPassageiros;
    }
    
    public String getNumeroQuadro() { return numeroQuadro; }
    public double getPeso() { return peso; }
    public int getMaxPassageiros() { return maxPassageiros; }
    
    @Override
    public String toString() {
        return super.toString() + " - Pesado Passageiros (" + peso + "kg, " + maxPassageiros + " lugares)";
    }
}
