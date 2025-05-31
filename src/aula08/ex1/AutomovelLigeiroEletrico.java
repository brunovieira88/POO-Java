package aula08.ex1;

public class AutomovelLigeiroEletrico extends AutomovelLigeiro implements IGestaoBateria{
    private double cargaAtual; 
    private double limiteCarga; 
    
    public AutomovelLigeiroEletrico(String matricula, String marca, String modelo, int potencia, 
                                   String numeroQuadro, int capacidadeBagageira) {
        super(matricula, marca, modelo, potencia, numeroQuadro, capacidadeBagageira);
        this.cargaAtual = 100.0;
        this.limiteCarga = 100.0;
    }
    
    @Override
    public double cargaDisponivel() {
        return cargaAtual;
    }
    
    @Override
    public void carregar(double percentagem) {
        double novaCarga = cargaAtual + percentagem;
        cargaAtual = Math.min(novaCarga, limiteCarga);
    }
    
    @Override
    public void limitarCargaMaxima(double percentagem) {
        this.limiteCarga = percentagem;
        if (cargaAtual > limiteCarga) {
            cargaAtual = limiteCarga;
        }
    }
    
    @Override
    public String toString() {
        return super.toString() + " - Elétrico (" + String.format("%.1f", cargaAtual) + "% bateria)";
    }
}
