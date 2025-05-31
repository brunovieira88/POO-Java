import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Parte1 {
    // -----------------------------------------------------
    //          !!! Não alterar este código !!!
    // -----------------------------------------------------
    private static int v1;
    private static List<Integer> v2 = new ArrayList<>();
    private static String v3;
    private static List<String> v4 = new ArrayList<>();
    // -----------------------------------------------------

    // -----------------------------------------------------------
    // >> Pode acrescentar novos métodos aqui (não é obrigatório)
    // -----------------------------------------------------------

    public static void lerTeclado() {
        Scanner sc = new Scanner(System.in);
        v1 = sc.nextInt();
        sc.nextLine();
        String[] v2Input = sc.nextLine().split(" ");
        for (String num : v2Input) {
            v2.add(Integer.parseInt(num));
        }
        v3 = sc.nextLine();

        String[] v4Input = sc.nextLine().split(" ");
        for (String str : v4Input) {
            v4.add(str);
        }
        sc.close();
    }

    public static void lerFicheiro() {
        try {
            Scanner sc = new Scanner(new File("inputs.txt"));
            v1 = sc.nextInt();
            sc.nextLine();
            String[] v2Input = sc.nextLine().split(" ");
            for (String num : v2Input) {
                v2.add(Integer.parseInt(num));
            }
            v3 = sc.nextLine();
            String[] v4Input = sc.nextLine().split(" ");
            for (String str : v4Input) {
                v4.add(str);
            }

            sc.close();
        } catch (FileNotFoundException e) {
            System.out.println("Ficheiro nao encontrado");
        }
    }

    public static void imprimir() {
        //print do v1
        System.out.println(v1);
        //print do v2
        for (int n : v2){
            System.out.print(n + " ");
        }
        //print do v3
        System.out.println(""); //para nao ficar colado ao v2
        System.out.println(v3);
        //print do v4
        for (String s : v4){
            System.out.print(s +" ");
        }
    }

    public static void main(String[] args) {
        // -----------------------------------------------------------------
        // !!! Não imprimir texto a pedir determinado input, ler direto !!!
        // -----------------------------------------------------------------

        lerTeclado();
        //lerFicheiro();
        imprimir();
    }
}
