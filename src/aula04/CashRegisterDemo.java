package aula04;

import java.util.ArrayList;

class Product {
    private String name;
    private double price;
    private int quantity;

    public Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public double getTotalValue() {
        return price * quantity;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int  getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return String.format("%-15s %10.2f %10d %10.2f", name, price, quantity, getTotalValue()); //total value do produto
    }
}


class CashRegister {
    ArrayList<Product> products = new ArrayList<>();
    //TODO: completar implementação da classe
    public void addProduct(Product product) {
        products.add(product);
    }

    public double getTotalValueFinal() { //totalvalue de todos os produtos juntos
        double total = 0;
        for (Product product : products){
            total += product.getTotalValue();
        }
        return total;
    }

    @Override 
    public String toString() { //ou com stringbuilder
        String result = String.format("%-15s %10s %10s %10s\n", "Product", "Price", "Quantity", "Total");
        for (Product product : products) {
            result += product.toString() + "\n"; //chama o metodo toString da classe ja formatado
        }
        result += String.format("\nTotal value: %.2f", getTotalValueFinal());
        return result;
    }

}

public class CashRegisterDemo {

    public static void main(String[] args) {

        // Cria e adiciona 5 produtos
        CashRegister cr = new CashRegister();
        cr.addProduct(new Product("Book", 9.99, 3));
        cr.addProduct(new Product("Pen", 1.99, 10));
        cr.addProduct(new Product("Headphones", 29.99, 2));
        cr.addProduct(new Product("Notebook", 19.99, 5));
        cr.addProduct(new Product("Phone case", 5.99, 1));
        cr.addProduct(new Product("Rubber", 1.99, 3));
        cr.addProduct(new Product("Markers", 3.99, 3));
        
        // TODO: Listar o conteúdo e valor total
        System.out.println(cr);

    }
}