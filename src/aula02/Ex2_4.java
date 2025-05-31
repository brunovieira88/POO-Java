package aula02;

import java.util.ArrayList;
import java.util.Scanner;
public class Ex2_4 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double number;
        double soma = 0;
        double min;
        double max;
        double media;
        ArrayList<Double> numbers = new ArrayList<Double>();
        while (true){
            System.out.print("Enter a number: ");
            number = scanner.nextDouble();
            numbers.add(number);
            if ( numbers.get(0) == number && numbers.size()>1){
                break;
            }
        } 
        scanner.close();
        min = numbers.get(0);
        max = numbers.get(0);
        for (double i : numbers){
            soma += i;
            if (i > max) {
                max = i;
            }
            if (i < min){
                min = i;
            }
            
        }
        media = soma/numbers.size();
        System.out.println("soma: " + soma);
        System.out.println("média: " + media);
        System.out.println("máximo: " + max);
        System.out.println("mínimo: " + min);
        System.out.println("Os valores acima da média sao:");
        for (double i : numbers){
            if (i > media){
                System.out.println(i);
            }
        }
    }
}
