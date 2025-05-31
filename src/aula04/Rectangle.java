package aula04;

import aula07.Forma;

public class Rectangle extends Forma{
    private double comprimento, altura;

    Rectangle(double comprimento, double altura, String cor){
        super(cor);
        setComprimento(comprimento);
        setAltura(altura);
    }

    public double getComprimento () {
        return comprimento;
    }

    public void setComprimento (double comp) {
        if (comp <= 0){
            throw new IllegalArgumentException("Valor invalido para comprimento");
        }
        this.comprimento = comp;
    }

    public double getAltura () {
        return altura;
    }

    public void setAltura (double alt) {
        if (alt <=0) {
            throw new IllegalArgumentException("Valor invalido para altura"); 
        }
        this.altura = alt;
    }
    @Override
    public double perimetro() {
        return comprimento*2 + altura*2;
    }
    @Override
    public double area() {
        return comprimento * altura;
    }

    @Override
    public String toString() {
        return "Rectangle: altura= "+altura+", comprimento= "+comprimento;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        long temp;
        temp = Double.doubleToLongBits(comprimento);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(altura);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (getClass() != obj.getClass())
            return false;
        Rectangle other = (Rectangle) obj;
        if (Double.doubleToLongBits(comprimento) != Double.doubleToLongBits(other.comprimento))
            return false;
        if (Double.doubleToLongBits(altura) != Double.doubleToLongBits(other.altura))
            return false;
        return true;
    }


}
