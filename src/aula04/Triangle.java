package aula04;

import aula07.Forma;

public class Triangle extends Forma{
    private double lado1, lado2, lado3;

    
    Triangle(double lado1, double lado2, double lado3, String cor) {
        super(cor);
        if (!(lado1 + lado2 > lado3) && (lado1 + lado3 > lado2) && (lado2 + lado3 > lado1)){ //desigualdade triangular
            throw new IllegalArgumentException("Os dados nao satsifazem a desigualdade triangular");
        }
        setLado1(lado1);
        setLado2(lado2);
        setLado3(lado3);
    }
    
    public double getLado1() {
        return lado1;
    }

    public void setLado1(double lado1) {
        if (lado1 <= 0){
            throw new IllegalArgumentException("Valor inválido para lado1.");
        }
        this.lado1 = lado1;
    }

    public double getLado2() {
        return lado2;
    }

    public void setLado2(double lado2) {
        if (lado2 <= 0 ){
            throw new IllegalArgumentException("Valor inválido para lado2.");
        }
        this.lado2 = lado2;
    }

    public double getLado3() {
        return lado3;
    }

    public void setLado3(double lado3) {
        if (lado3 <= 0){
            throw new IllegalArgumentException("Valor inválido para lado3.");
        }
        this.lado3 = lado3;
    }
    @Override
    public double perimetro(){
        return lado1 + lado2 + lado3;
    }
    @Override
    public double area() {
        double s = perimetro() / 2; //semiperimetro
        return Math.sqrt(s * (s - lado1) * (s - lado2) * (s - lado3));//formula de heron
    }

    @Override
    public String toString() {
        return "Triangle: lado1=" + lado1 + ", lado2=" + lado2 + ", lado3=" + lado3;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        long temp;
        temp = Double.doubleToLongBits(lado1);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(lado2);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(lado3);
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
        Triangle other = (Triangle) obj;
        if (Double.doubleToLongBits(lado1) != Double.doubleToLongBits(other.lado1))
            return false;
        if (Double.doubleToLongBits(lado2) != Double.doubleToLongBits(other.lado2))
            return false;
        if (Double.doubleToLongBits(lado3) != Double.doubleToLongBits(other.lado3))
            return false;
        return true;
    }
    
}
