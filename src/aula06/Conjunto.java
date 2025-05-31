package aula06;

import java.util.ArrayList;

public class Conjunto{
    private ArrayList <Integer> numeros;

    public Conjunto(){
        this.numeros = new ArrayList<Integer>();
    }

    public void insert(int d){
        if (!contains(d)){
            numeros.add(d);
        }
    }

    public boolean contains(int n){
        for (int num : numeros) {
            if (num == n) {
                return true;
            }
        }
        return false;
    }

    public void remove(int d){
        if(contains(d)){
            numeros.remove(Integer.valueOf(d));
        }
    }

    public void empty(){
        this.numeros = new ArrayList<Integer>();
    }

    @Override
    public String toString(){
        StringBuffer sb = new StringBuffer();
        for(int num: numeros){
            sb.append(num).append(" ");
        }

        return sb.toString().trim();
    }

    public int size(){
        int len=0;
        for(int num: numeros){
            len++;
        }
        return len;
    }

    public Conjunto combine(Conjunto add) {
        Conjunto result = new Conjunto();
        result.numeros.addAll(this.numeros); //copiar o conjunto atual
        for (int num : add.numeros) {  
            result.insert(num);               
        }
        return result;
    }

    public Conjunto subtract(Conjunto diff) {
        Conjunto result = new Conjunto();
        result.numeros.addAll(this.numeros); 
        for (int num : diff.numeros) {
            result.remove(num);
        }
        return result;
    }

    public Conjunto intersect(Conjunto inter) {
        Conjunto result = new Conjunto();
        for (int num : this.numeros) {
            for(int x: inter.numeros){
                if(num==x){
                    result.insert(x);
                }
            }
               
        }
        return result;
    }

    public static void main(String[] args) {
            Conjunto c1 = new Conjunto();
            c1.insert(4); c1.insert(7); c1.insert(6); c1.insert(5);
            Conjunto c2 = new Conjunto();
            int[] test = { 7, 3, 2, 5, 4, 6, 7};
            for (int el : test) c2.insert(el);
            c2.remove(3); c2.remove(5); c2.remove(6);
            System.out.println(c1);
            System.out.println(c2);
            System.out.println("Número de elementos em c1: " + c1.size());
            System.out.println("Número de elementos em c2: " + c2.size());

            System.out.println("c1 contém 6?: " + ((c1.contains(6) ? "sim" : "não")));
            System.out.println("c2 contém 6?: " + ((c2.contains(6) ? "sim" : "não")));
            System.out.println("União:" + c1.combine(c2));
            System.out.println("Interseção:" + c1.intersect(c2));
            System.out.println("Diferença:" + c1.subtract(c2));
            c1.empty();
            System.out.println("c1:" + c1);
    }
}
