package aula08.ex1;

public class PesadoMercadorias extends Veiculo{
    private String numeroQuadro;
    private double peso;
    private double cargaMaxima;
    
    public PesadoMercadorias(String matricula, String marca, String modelo, int potencia, String numeroQuadro, double peso, double cargaMaxima) {
        super(matricula, marca, modelo, potencia);
        this.numeroQuadro = numeroQuadro;
        this.peso = peso;
        this.cargaMaxima = cargaMaxima;
    }
    
    public String getNumeroQuadro() { return numeroQuadro; }
    public double getPeso() { return peso; }
    public double getCargaMaxima() { return cargaMaxima; }
    
    @Override
    public String toString() {
        return super.toString() + " - Pesado Mercadorias (" + peso + "kg, " + cargaMaxima + "kg max)";
    }
}
