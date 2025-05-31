package aula08.ex1;

public class Motociclo extends Veiculo{
    private String tipo;
    public Motociclo(String matricula, String marca, String modelo, int potencia, String tipo) {
        super(matricula, marca, modelo, potencia);
        this.tipo = tipo;
    }
    
    public String getTipo() { return tipo; }
    
    @Override
    public String toString() {
        return super.toString() + " - Motociclo " + tipo;
    }
}
