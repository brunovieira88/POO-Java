package aula07;

import aula05.DateYMD;

public class Main {
    public static void main(String[] args) {
        DateYMD data1 = new DateYMD(29, 2, 2020);
        System.out.println("DateYMD: " + data1);
        
        data1.increment();
        System.out.println("DateYMD incrementado: " + data1);
        

        DateND data2 = new DateND(1, 1, 2000);
        System.out.println("\nDateND (referência): " + data2);
        
        DateND data3 = new DateND(7350); // ~20 anos depois
        System.out.println("DateND (7350 dias depois): " + data3);
        
        //polimorfismo
        Date data4 = new DateYMD(10, 10, 2010);
        Date data5 = new DateND(10, 10, 2010);
        
        System.out.println("\nComparação de datas:");
        System.out.println("DateYMD: " + data4);
        System.out.println("DateND:  " + data5);
    }
}