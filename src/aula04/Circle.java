package aula04;

import aula07.Forma;

public class Circle extends Forma{
    private double raio;

    Circle(double raio, String cor){
        super(cor);
        setRaio(raio);
    }

    public double getRaio() {
        return raio;
    } 

    public void setRaio(double rad) {
        if(rad <= 0){
            throw new IllegalArgumentException("Valor invalido para raio");
        }
        this.raio = rad;
    }
    @Override
    public String toString() {
        return "Circle: radius= "+raio;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        long temp;
        temp = Double.doubleToLongBits(raio);
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
        Circle other = (Circle) obj;
        if (Double.doubleToLongBits(raio) != Double.doubleToLongBits(other.raio))
            return false;
        return true;
    }

    @Override
    public double perimetro() {
        return 2 * Math.PI * raio;
    }

    @Override
    public double area() {
        return Math.PI * Math.pow(raio, 2);
    }

}
