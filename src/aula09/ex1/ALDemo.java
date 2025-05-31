package aula09.ex1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;
import aula06.Pessoa;
import aula07.Date;
import aula05.DateYMD;


public class ALDemo {
    public static void main(String[] args) {
        ArrayList<Integer> c1 = new ArrayList<>();
        for (int i = 10; i <= 100; i+=10)
            c1.add(i);

        System.out.println("Size: " + c1.size());
        for (int i = 0; i < c1.size(); i++)
            System.out.println("Elemento: " + c1.get(i));

        ArrayList<String> c2 = new ArrayList<>();
        c2.add("Vento");
        c2.add("Calor");
        c2.add("Frio");
        c2.add("Chuva");
        System.out.println(c2);
        Collections.sort(c2);
        System.out.println(c2);
        c2.remove("Frio");
        c2.remove(0);
        System.out.println(c2);
        System.out.println(c2.contains("Frio"));
        System.out.println(c2.indexOf("Vento"));
        System.out.println(c2.set(0, "Sol"));


        Set<Pessoa> c3 = new HashSet<>();
        DateYMD d1 = new DateYMD(5, 12, 1988);
        c3.add(new Pessoa("João", 123456789, d1));
        DateYMD d2 = new DateYMD(4, 11, 1990);
        c3.add(new Pessoa("Maria", 123456781, d2));    
        DateYMD d3 = new DateYMD(3, 10, 1990);
        c3.add(new Pessoa("Ana", 123456782, d3));
        DateYMD d4 = new DateYMD(2, 9, 1990);
        c3.add(new Pessoa("Pedro", 123456783, d4));
        DateYMD d5 = new DateYMD(1, 8, 1990);
        c3.add(new Pessoa("Carlos", 123456784, d5));

        for (Pessoa p : c3) {
            System.out.println(p);
        }

        c3.add(new Pessoa("João", 123456789, d1));

        TreeSet<DateYMD> c4 = new TreeSet<>();
        DateYMD date1 = new DateYMD(10, 10, 2010);
        c4.add(date1);
        DateYMD date2 = new DateYMD(8, 10, 2009);
        c4.add(date2);
        DateYMD date3 = new DateYMD(16, 5, 2006);
        c4.add(date3);
        DateYMD date4 = new DateYMD(10, 12, 2009);
        c4.add(date4);
        DateYMD date5 = new DateYMD(11, 3, 1999);
        c4.add(date5);

        for(Date d: c4){
            System.out.println(d);
        }        
        
    }
}
