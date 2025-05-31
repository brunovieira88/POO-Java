package aula10.ex4;

public class Companhia {
    private String sigla, nome;

    Companhia(String sigla, String nome){
        this.sigla = sigla;
        this.nome = nome;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override 
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(sigla).append(" - ").append(nome);
        return sb.toString();
    }
}
