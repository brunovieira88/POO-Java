package aula08.ex3;

import java.util.ArrayList;

public class CarrinhoDeCompras implements Compra{
    public ArrayList<Produto> produtos;
    double total = 0;
    CarrinhoDeCompras (){
        this.produtos = new ArrayList<>();
        this.total = 0;
    }
    @Override
    public void adicionarProduto (Produto produto, int quantidade){
        if ( produto.getQuantidade() >= quantidade){
            produto.removerQuantidade(quantidade);
            total += quantidade * produto.getPreco();
            produtos.add(produto);
        }else{
            throw new IllegalArgumentException("Quantidade de "+produto.getNome()+" nao disponivel");
        }
    }

    @Override
    public void listarProdutos (){
        for (Produto produto : produtos){
            System.out.println(produto.toString());
        }
    }

    @Override
    public double calcularTotal(){
     return total;
    }
}
