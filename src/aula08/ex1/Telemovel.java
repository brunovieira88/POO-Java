package aula08.ex1;

public class Telemovel implements IGestaoBateria{
    private String numero;
    private String marca;
    private String modelo;
    private double cargaAtual; // percentagem
    private double limiteCarga; // percentagem
    
    public Telemovel(String numero, String marca, String modelo) {
        this.numero = numero;
        this.marca = marca;
        this.modelo = modelo;
        this.cargaAtual = 100.0;
        this.limiteCarga = 100.0;
    }
    
    @Override
    public double cargaDisponivel() {
        return cargaAtual;
    }
    
    @Override
    public void carregar(double percentagem) {
        double novaCarga = cargaAtual + percentagem;
        cargaAtual = Math.min(novaCarga, limiteCarga);
    }
    
    @Override
    public void limitarCargaMaxima(double percentagem) {
        this.limiteCarga = percentagem;
        if (cargaAtual > limiteCarga) {
            cargaAtual = limiteCarga;
        }
    }
    
    @Override
    public String toString() {
        return String.format("%s %s (%s) - %.1f%% bateria", marca, modelo, numero, cargaAtual);
    }
}
