package aula08.ex1;

public class Atleta implements IKmPercorridos{
    private String nome;
    private String localidade;
    private int kmTreinoTotal;
    private int ultimoTreino;
    
    public Atleta(String nome, String localidade) {
        this.nome = nome;
        this.localidade = localidade;
        this.kmTreinoTotal = 0;
        this.ultimoTreino = 0;
    }
    
    @Override
    public void trajeto(int quilometros) {
        this.ultimoTreino = quilometros;
        this.kmTreinoTotal += quilometros;
    }
    
    @Override
    public int ultimoTrajeto() {
        return this.ultimoTreino;
    }
    
    @Override
    public int distanciaTotal() {
        return this.kmTreinoTotal;
    }
    
    public void viajarParaBerlim(AutomovelLigeiro veiculo) {
        veiculo.trajeto(2700);
    }
    
    private Telemovel telemovel;
    
    public void setTelemovel(Telemovel telemovel) {
        this.telemovel = telemovel;
    }
    
    public Telemovel getTelemovel() {
        return telemovel;
    }
    
    @Override
    public String toString() {
        String telStr = (telemovel != null) ? " - " + telemovel : "";
        return String.format("%s (%s) - %d km treino total%s", nome, localidade, kmTreinoTotal, telStr);
    }
}
