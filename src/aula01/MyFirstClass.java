package aula01;

public class MyFirstClass {
    public static void main(String[] args) {
        System.out.println("Hello VS Code!");
        int sum = 0;
        for (int i = 1; i<=100; i++ ){   //ou (int i = 0; i<100; i++) 
            sum +=i ;
        }
        System.out.printf("A soma é %d\n", sum);
        System.out.println("...");
    }   
}
