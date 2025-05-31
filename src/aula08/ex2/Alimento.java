package aula08.ex2;

public abstract class Alimento implements Comparable<Alimento>{
    protected double proteinas;
    protected double calorias;
    protected double peso;
    
    public Alimento(double proteinas, double calorias, double peso) {
        this.proteinas = proteinas;
        this.calorias = calorias;
        this.peso = peso;
    }
    
    public double getProteinas() { return proteinas; }
    public double getCalorias() { return calorias; }
    public double getPeso() { return peso; }
    
    public double getProteinasTotais() { return (proteinas * peso) / 100; }
    public double getCaloriasTotais() { return (calorias * peso) / 100; }
    
    public abstract boolean isVegetariano();
    
    @Override
    public int compareTo(Alimento a) {
        return Double.compare(this.getCaloriasTotais(), a.getCaloriasTotais());
    }
    
    @Override
    public abstract String toString();

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        long temp;
        temp = Double.doubleToLongBits(proteinas);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(calorias);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(peso);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Alimento other = (Alimento) obj;
        if (Double.doubleToLongBits(proteinas) != Double.doubleToLongBits(other.proteinas))
            return false;
        if (Double.doubleToLongBits(calorias) != Double.doubleToLongBits(other.calorias))
            return false;
        if (Double.doubleToLongBits(peso) != Double.doubleToLongBits(other.peso))
            return false;
        return true;
    }
    
}
