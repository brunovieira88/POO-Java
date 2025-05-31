package aula05;

public class Imovel {
    private static int lastId = 1000;
    private int id;
    private int numeroQuartos;
    private String localidade;
    private double preco;
    private boolean disponivel;
    private DateYMD dataInicioLeilao, dataFimLeilao;

    //construtor
    public Imovel(int numeroQuartos, String localidade, double preco, boolean disponivel, DateYMD dataInicioLeilao, DateYMD dataFimLeilao) {
        this.id = lastId++;
        this.numeroQuartos = numeroQuartos;
        this.localidade = localidade;
        this.preco = preco;
        this.disponivel = disponivel;
        this.dataInicioLeilao = dataInicioLeilao;
        this.dataFimLeilao = dataFimLeilao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumeroQuartos() {
        return numeroQuartos;
    }

    public void setNumeroQuartos(int numeroQuartos) {
        this.numeroQuartos = numeroQuartos;
    }

    public String getLocalidade() {
        return localidade;
    }

    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    public DateYMD getDataInicioLeilao() {
        return dataInicioLeilao;
    }

    public void setDataInicioLeilao(DateYMD dataInicioLeilao) {
        this.dataInicioLeilao = dataInicioLeilao;
    }

    public DateYMD getDataFimLeilao() {
        return dataFimLeilao;
    }

    public void setDataFimLeilao(DateYMD dataFimLeilao) {
        this.dataFimLeilao = dataFimLeilao;
    }

    @Override
    public String toString() {
        String disponibilidade = disponivel ? "sim" : "não"; //se esta disponivel = sim ; se nao =nao
        String leilaoInfo = "";
        if (dataInicioLeilao != null && dataFimLeilao != null) {
            leilaoInfo = "; leilão " + dataInicioLeilao + " : " + dataFimLeilao;
        }
        return "Imóvel: " + id + "; quartos: " + numeroQuartos + "; localidade: " + localidade +
                "; preço: " + preco + "; disponível: " + disponibilidade + leilaoInfo;
    }
}

