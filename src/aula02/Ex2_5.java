package aula02;

import java.util.Scanner;
public class Ex2_5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String firstInput;
        System.out.print("escreve uma frase ou palavra: ");
        firstInput = scanner.nextLine();
        System.out.println(firstInput.toLowerCase());
        System.out.println(firstInput.substring(0,1));
        System.out.println(firstInput.substring(0, 4));
        System.out.println(firstInput.replace('a', 'v'));          
        System.out.println(firstInput.replaceAll("\\s", "_"));  
        System.out.println(firstInput.toUpperCase());
        System.out.println(firstInput.lastIndexOf("b"));  //retorna -1 se nao existir 
        scanner.close();
    }
}
