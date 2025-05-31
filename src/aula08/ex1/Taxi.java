package aula08.ex1;

public class Taxi extends AutomovelLigeiro{
    private String numeroLicenca;
    
    public Taxi(String matricula, String marca, String modelo, int potencia, String numeroQuadro,int capacidadeBagageira, String numeroLicenca) {
        super(matricula, marca, modelo, potencia, numeroQuadro, capacidadeBagageira);
        this.numeroLicenca = numeroLicenca;
    }

    public String getNumeroLicenca() { return numeroLicenca; }
    
    @Override
    public String toString() {
        return super.toString() + " - Táxi " + numeroLicenca;
    }
}
