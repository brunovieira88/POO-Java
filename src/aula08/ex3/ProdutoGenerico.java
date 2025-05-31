package aula08.ex3;

public class ProdutoGenerico implements Produto{
    String nome;
    int quantidade;
    double price;

    ProdutoGenerico (String nome, int quantidade, double price){
        this.nome = nome;
        this.quantidade = quantidade;
        this.price = price;
    }

    @Override
    public String getNome() {
        return this.nome;
    }

    @Override
    public double getPreco(){ return this.price;}

    @Override 
    public int getQuantidade(){ return this.quantidade;}

    @Override
    public void adicionarQuantidade(int quantidade){
        this.quantidade+= quantidade;
    }

    @Override 
    public void removerQuantidade(int quantidade){
        this.quantidade -= quantidade;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "ProdutoGenerico [nome=" + nome + ", quantidade=" + quantidade + ", price=" + price + "]  ";
    }    
}
