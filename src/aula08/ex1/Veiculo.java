package aula08.ex1;

public abstract class Veiculo implements IKmPercorridos{
    protected String matricula;
    protected String marca;
    protected String modelo;
    protected int potencia;
    protected int kmTotal;
    protected int ultimoTrajeto;

    public Veiculo(String matricula, String marca, String modelo, int potencia) {
        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
        this.potencia = potencia;
        this.kmTotal = 0;
        this.ultimoTrajeto = 0;
    }
    
    @Override
    public void trajeto(int quilometros) {
        this.ultimoTrajeto = quilometros;
        this.kmTotal += quilometros;
    }
    
    @Override
    public int ultimoTrajeto() {
        return this.ultimoTrajeto;
    }
    
    @Override
    public int distanciaTotal() {
        return this.kmTotal;
    }
    
    public String getMatricula() { 
        return matricula; 
    }
    public String getMarca() { 
        return marca; 
    }
    public String getModelo() { 
        return modelo; 
    }
    public int getPotencia() { 
        return potencia; 
    }
    
    @Override
    public String toString() {
        return String.format("%s %s (%s) - %d cv", marca, modelo, matricula, potencia);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((matricula == null) ? 0 : matricula.hashCode());
        result = prime * result + ((marca == null) ? 0 : marca.hashCode());
        result = prime * result + ((modelo == null) ? 0 : modelo.hashCode());
        result = prime * result + potencia;
        result = prime * result + kmTotal;
        result = prime * result + ultimoTrajeto;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Veiculo veiculo = (Veiculo) obj;
        return matricula.equals(veiculo.matricula);
    }

    
    
    
}
