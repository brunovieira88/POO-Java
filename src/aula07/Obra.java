package aula07;

public abstract class Obra {
    private static int idCounter = 33;
    private int id;
    private String nome, autor;
    private double basePrice, sellPrice;
    private boolean vendida;

    public Obra(String nome, String autor, double basePrice) {
        this.id = idCounter++;
        this.nome = nome;
        this.autor = autor;
        this.basePrice = basePrice;
        this.vendida = false;
        this.sellPrice = 0;
    }
    public void vender(double sellPrice) {
        this.vendida = true;
        this.sellPrice = sellPrice;
    }
    
    public double calcularLucro() {
        return vendida ? sellPrice - basePrice : 0;
    }


    public static int getIdCounter() {
        return idCounter;
    }

    public static void setIdCounter(int idCounter) {
        Obra.idCounter = idCounter;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(double basePrice) {
        this.basePrice = basePrice;
    }

    public double getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(double sellPrice) {
        this.sellPrice = sellPrice;
    }

    public boolean isVendida() {
        return vendida;
    }

    public void setVendida(boolean vendida) {
        this.vendida = vendida;
    }

    @Override
    public String toString() {
        return String.format(
            "Nome: %s Autor: %s Preço: %.1f Identificador: %d", 
            nome, autor, basePrice, id);
    }

}
