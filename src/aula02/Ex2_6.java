package aula02;

import java.util.Scanner;
public class Ex2_6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String frase;
        System.out.print("Escreve uma frase: ");
        frase = scanner.nextLine();
        System.out.println("number of digits: "+countDigits(frase));
        System.out.println("number of spaces: "+countSpaces(frase));
        System.out.println("is all lower cases: "+isUp(frase));
        System.out.println("2 blank spaces or more: " +removeDoubleSpaces(frase));
        System.out.println("is a palindrome: "+isPlain(frase));

        scanner.close();
        
    }
    public static int countDigits(String s){
        int count = 0;
        for (int i=0; i < s.length(); i++){
            if(Character.isDigit(s.charAt(i))) {
                count++;
            }
        }
        return count;
    }
    public static int countSpaces(String s){
        int count = 0;
        for (int i=0; i < s.length(); i++){
            if(Character.isWhitespace(s.charAt(i))) {
                count++;
            }
        }
        return count;
    }
    public static boolean isUp(String s){
        for (int i=0; i < s.length(); i++){
            if(Character.isUpperCase(s.charAt(i))) { //ou usar toLowercase e ver se é igual a original
                return false;
            }
        } 
        return true;
    }
    public static String removeDoubleSpaces(String s){
         return s.replaceAll("[ ]+", " ");
     }
    public static boolean isPlain(String s){
        String f = "";
        for (int i = s.length()-1; i >= 0; i--){  // ou usar s.reverse().toString()
            f = f+s.charAt(i);
        }
        if (s.equals(f)){
            return true;
        }
        return false;   
    }
}

