package aula08.ex3;

public class ProdutoComDesconto extends ProdutoGenerico{
    double desconto;
    ProdutoComDesconto (String nome, int quantidade, double price, double desconto){
        super(nome, quantidade, price);
        this.desconto = desconto;
    }
    public void setDesconto(double desconto){
        this.desconto = desconto;
    }

    public double getDesconto(){ return desconto;}

    @Override
    public double getPreco(){
        return price*((100-desconto)/100);
    }

    @Override
    public String toString() {
        return "ProdutoComDesconto [nome=" + nome + ", desconto=" + desconto + ", quantidade=" + quantidade + ", price="
                + price + "]  ";
    }       
}
