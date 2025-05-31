package aula03;

import java.util.Scanner;

public class Ex3_1 {
    public static void main(String[] args) {
        int num = 0;
        int sum = 0;
        Scanner scanner = new Scanner(System.in);
        while( num < 1){
            System.out.print("Enter a number: ");
            num = scanner.nextInt();
        }
        for(int j = 1; j <= num; j++){
            if (isPrime(j)){
                sum+=j;
            }
        }
        System.out.printf("SUM OF PRIME NUMBERS (1-%d): %d", num, sum);
        scanner.close();
    }
    public static boolean isPrime(int x){
        if ( x < 2) { 
            return false; 
        }
        if(x==3 || x==2){
            return true;
        }
        if( x % 2 == 0 || x % 3 == 0){
            return false;
        }
        // Check for factors of x starting from 5 and skipping even numbers and multiples of 3
        for (int i = 5; i*i <= x; i+=6){
            if (x % i == 0 || x % (i+2) == 0){
                return false;
            }
        }
        return true;
    }
}
